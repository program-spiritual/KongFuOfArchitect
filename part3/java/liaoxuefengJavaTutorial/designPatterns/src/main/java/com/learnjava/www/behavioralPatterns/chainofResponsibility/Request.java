package com.learnjava.www.behavioralPatterns.chainofResponsibility;

import java.math.BigDecimal;

public class Request {

  private String name;
  private BigDecimal amount;

  public Request(String name, BigDecimal amount) {
    this.name = name;
    this.amount = amount;
  }

  public String getName() {
    return name;
  }

  public BigDecimal getAmount() {
    return amount;
  }
}
