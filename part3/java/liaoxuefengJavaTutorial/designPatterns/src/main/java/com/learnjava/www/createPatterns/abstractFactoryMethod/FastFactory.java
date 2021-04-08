package com.learnjava.www.createPatterns.abstractFactoryMethod;

public class FastFactory implements AbstractFactory {

  @Override
  public HtmlDocument createHtml(String md) {
    return new FastHtmlDocument(md);
  }

  @Override
  public WordDocument createWord(String md) {
    return new FastWordDocument(md);
  }
}
