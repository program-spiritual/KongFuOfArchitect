package com.learnjava.www.createPatterns.builder;

import java.util.Map;
import java.util.stream.IntStream;

public class SimpleUrlBuilder {

  public static void main(String[] args) {
    String url = URLBuilder
      .builder() // 创建Builder
      .setDomain("www.liaoxuefeng.com") // 设置domain
      .setScheme("https") // 设置scheme
      .setPath("/") // 设置路径
      .setQuery(Map.of("a", "123", "q", "K&R")) // 设置query
      .build(); // 完成build
  }
}
