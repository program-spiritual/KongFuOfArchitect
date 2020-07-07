package com.learnjava.www.behavioralPatterns.strategy;

import java.math.BigDecimal;

public interface DiscountStrategy {
    // 计算折扣额度:
    BigDecimal getDiscount(BigDecimal total);
}
