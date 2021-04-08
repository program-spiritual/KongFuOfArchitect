package com.learnjava.www.createPatterns.abstractFactoryMethod;

import java.io.IOException;
import java.nio.file.Paths;

public class Main {

  public static void main(String[] args) {
    // 创建AbstractFactory，实际类型是FastFactory:
    AbstractFactory factory = new FastFactory();
    // 生成Html文档:
    HtmlDocument html = factory.createHtml("#Hello\nHello, world!");
    try {
      html.save(Paths.get(".", "fast.html"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    // 生成Word文档:
    AbstractFactory fastFactory = null;
    WordDocument word = fastFactory.createWord("#Hello\nHello, world!");
    try {
      word.save(Paths.get(".", "fast.doc"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
