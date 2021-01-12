import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DarkRule {
    // 从配置文件中加载的灰度规则
    private Map<String, IDarkFeature> darkFeatures = new HashMap<>();
    // 编程实现的灰度规则
    private final ConcurrentHashMap<String, IDarkFeature> programmedDarkFeatures = new ConcurrentHashMap<>();

    public DarkRule(DarkRuleConfig darkRuleConfig) {
        List<DarkRuleConfig.DarkFeatureConfig> darkFeatureConfigs = darkRuleConfig.getFeatures();
        for (DarkRuleConfig.DarkFeatureConfig darkFeatureConfig : darkFeatureConfigs) {
            darkFeatures.put(darkFeatureConfig.getKey(), new DarkFeature(darkFeatureConfig));
        }
    }

    public void addProgrammedDarkFeature(String featureKey, IDarkFeature darkFeature) {
        programmedDarkFeatures.put(featureKey, darkFeature);
    }

    public DarkFeature getDarkFeature(String featureKey) {
        IDarkFeature darkFeature = programmedDarkFeatures.get(featureKey);
        if (darkFeature != null) {
            return (DarkFeature) darkFeature;
        }
        return (DarkFeature) darkFeatures.get(featureKey);
    }

    public void setDarkFeatures(Map<String, IDarkFeature> newDarkFeatures) {
        this.darkFeatures = newDarkFeatures;
    }
}
