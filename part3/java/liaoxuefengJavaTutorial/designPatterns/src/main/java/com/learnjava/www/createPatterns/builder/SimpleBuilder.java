package com.learnjava.www.createPatterns.builder;

public class SimpleBuilder {

  public static void main(String[] args) {
    StringBuilder builder = new StringBuilder();
    boolean secure = false;
    builder
      .append(secure ? "https://" : "http://")
      .append("www.liaoxuefeng.com")
      .append("/")
      .append("?t=0");
    String url = builder.toString();
  }
}
