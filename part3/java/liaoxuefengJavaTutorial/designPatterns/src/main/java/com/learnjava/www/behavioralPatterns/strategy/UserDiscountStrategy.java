package com.learnjava.www.behavioralPatterns.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class UserDiscountStrategy implements DiscountStrategy {

  @Override
  public BigDecimal getDiscount(BigDecimal total) {
    return total.multiply(new BigDecimal("0.1")).setScale(2, RoundingMode.DOWN);
  }
}
