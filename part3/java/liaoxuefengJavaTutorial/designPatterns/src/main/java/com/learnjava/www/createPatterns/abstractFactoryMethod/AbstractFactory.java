package com.learnjava.www.createPatterns.abstractFactoryMethod;

public interface AbstractFactory {
    // 创建Html文档:
    HtmlDocument createHtml(String md);

    // 创建Word文档:
    WordDocument createWord(String md);

    public static AbstractFactory createFactory(String name) {
        if (name.equalsIgnoreCase("fast")) {
            return new FastFactory();
        } else if (name.equalsIgnoreCase("good")) {
            return new GoodFactory();
        } else {
            throw new IllegalArgumentException("Invalid factory name");
        }
    }
}
