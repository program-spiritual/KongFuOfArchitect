package com.learnjava.www.createPatterns.abstractFactoryMethod;

public class GoodFactory implements AbstractFactory {

  @Override
  public HtmlDocument createHtml(String md) {
    return new GoodHtmlDocument(md);
  }

  @Override
  public WordDocument createWord(String md) {
    return new GoodWordDocument(md);
  }
}
