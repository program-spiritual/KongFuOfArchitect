package FactoryMethod;

import simpleFactory.IRuleConfigParser;

public class YamlRuleConfigParserFactory implements IRuleConfigParserFactory{

    @Override
    public IRuleConfigParser createParser() {
        return null;
    }
}
