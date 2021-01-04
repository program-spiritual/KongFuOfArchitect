package dIContainer;

import java.io.InputStream;
import java.util.List;

public class ClassPathXmlApplicationContext implements ApplicationContext {
    private BeansFactory beansFactory;
    private BeanConfigParser beanConfigParser;

    public ClassPathXmlApplicationContext(String configLocation) throws BeanCreationFailureException {
        this.beansFactory = new BeansFactory();
        this.beanConfigParser = new XmlBeanConfigParser();
        loadBeanDefinitions(configLocation);
    }

    private void loadBeanDefinitions(String configLocation) throws BeanCreationFailureException {
        InputStream in = null;
        in = this.getClass().getResourceAsStream("/" + configLocation);
        System.out.println(in);
        if (in == null) {
            throw new RuntimeException("Can not find config file: " + configLocation);
        }
        List<BeanDefinition> beanDefinitions = beanConfigParser.parse(in);
        beansFactory.addBeanDefinitions(beanDefinitions);
    }

    @Override
    public Object getBean(String beanId) {
        return beansFactory.getBean(beanId);
    }
}
