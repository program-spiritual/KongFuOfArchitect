import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DarkLaunch {
    public static final Logger log = LoggerFactory.getLogger(DarkLaunch.class);
    public static final int DEFAULT_RULE_UPDATE_TIME_INTERVAL = 60; // in seconds
    private DarkRule rule;
    private ScheduledExecutorService executor;

    public DarkLaunch(int ruleUpdateTimeInterval) {
        loadRule();
        this.executor = Executors.newSingleThreadScheduledExecutor();
        this.executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                loadRule();
            }
        }, ruleUpdateTimeInterval, ruleUpdateTimeInterval, TimeUnit.SECONDS);
    }

    public DarkLaunch() {
        this(DEFAULT_RULE_UPDATE_TIME_INTERVAL);
    }

    private void loadRule() {
        // 将灰度规则配置文件dark-rule.yaml中的内容读取DarkRuleConfig中
        InputStream in = null;
        DarkRuleConfig ruleConfig = null;
        try {
            in = this.getClass().getResourceAsStream("/dark-rule.yaml");
            if (in != null) {
                Yaml yaml = new Yaml();
                ruleConfig = yaml.loadAs(in, DarkRuleConfig.class);
            }
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    log.error("close file error:{}", e);
                }
            }
        }

        if (ruleConfig == null) {
            throw new RuntimeException("Can not load dark rule.");
        }

        // 更新规则并非直接在this.rule上进行，
        //而是通过创建一个新的DarkRule，然后赋值给this.rule，
        //来避免更新规则和规则查询的并发冲突问题
//        this.rule = new DarkRule(ruleConfig);
        Map<String, IDarkFeature> darkFeatures = new HashMap<>();
        List<DarkRuleConfig.DarkFeatureConfig> darkFeatureConfigs = ruleConfig.getFeatures();
        for (DarkRuleConfig.DarkFeatureConfig darkFeatureConfig : darkFeatureConfigs) {
            darkFeatures.put(darkFeatureConfig.getKey(), new DarkFeature(darkFeatureConfig));
        }
        this.rule.setDarkFeatures(darkFeatures);
    }

    public void addProgrammedDarkFeature(String featureKey , IDarkFeature darkFeature) {
        this.rule.addProgrammedDarkFeature(featureKey,darkFeature);
    }

    public DarkFeature getDarkFeature(String featureKey) {
        return this.rule.getDarkFeature(featureKey);
    }
}
