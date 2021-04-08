package com.learnjava.www.behavioralPatterns.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PrimeDiscountStrategy implements DiscountStrategy {

  @Override
  public BigDecimal getDiscount(BigDecimal total) {
    BigDecimal result = total;

    if (result.compareTo(BigDecimal.valueOf(100)) >= 0) {
      result = result.subtract(BigDecimal.valueOf(20));
    }

    result =
      result.multiply(new BigDecimal("0.7")).setScale(2, RoundingMode.DOWN);

    return total.subtract(result);
  }
}
