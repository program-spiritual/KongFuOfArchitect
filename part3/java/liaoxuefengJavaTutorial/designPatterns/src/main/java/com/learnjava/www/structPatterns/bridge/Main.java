package com.learnjava.www.structPatterns.bridge;

public class Main {

  public static void main(String[] args) {
    RefinedCar car = new BossCar(new HybridEngine());
    car.drive();
  }
}
