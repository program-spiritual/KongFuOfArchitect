package com.learnjava.www.behavioralPatterns.strategy;

import java.math.BigDecimal;

public class DiscountContext {

  // 持有某个策略:

  private DiscountStrategy strategy = new UserDiscountStrategy();

  // 允许客户端设置新策略:

  public void setStrategy(DiscountStrategy strategy) {
    this.strategy = strategy;
  }

  public BigDecimal calculatePrice(BigDecimal total) {
    return total.subtract(this.strategy.getDiscount(total)).setScale(2);
  }
}
