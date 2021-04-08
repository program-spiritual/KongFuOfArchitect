package com.learnjava.www.createPatterns.factoryMethod;

public class Main {

  public static void main(String[] args) {
    NumberFactory factory = NumberFactory.getFactory();
    Number result = factory.parse("123.456");
    System.out.println(result);
  }
}
