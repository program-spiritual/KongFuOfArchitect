package com.learnjava.www.createPatterns.singleton;

public enum World {
  // 唯一枚举:
  INSTANCE;

  private String name = "world";

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
