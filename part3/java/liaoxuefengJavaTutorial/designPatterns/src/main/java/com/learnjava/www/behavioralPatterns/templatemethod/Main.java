package com.learnjava.www.behavioralPatterns.templatemethod;

public class Main {

  public static void main(String[] args) {
    AbstractSetting setting1 = new LocalSetting();
    System.out.println("test = " + setting1.getSetting("test"));
    System.out.println("test = " + setting1.getSetting("test"));
  }
}
