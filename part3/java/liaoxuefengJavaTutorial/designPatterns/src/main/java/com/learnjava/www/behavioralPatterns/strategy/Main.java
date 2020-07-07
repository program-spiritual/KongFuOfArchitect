package com.learnjava.www.behavioralPatterns.strategy;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        String[] array = { "apple", "Pear", "Banana", "orange" };

        Arrays.sort(array, String::compareToIgnoreCase);

        System.out.println(Arrays.toString(array));

        DiscountContext ctx = new DiscountContext();

// 默认使用普通会员折扣:
        BigDecimal pay1 = ctx.calculatePrice(BigDecimal.valueOf(105));
        System.out.println(pay1);

// 使用满减折扣:
        ctx.setStrategy(new OverDiscountStrategy());
        BigDecimal pay2 = ctx.calculatePrice(BigDecimal.valueOf(105));
        System.out.println(pay2);

// 使用Prime会员折扣:
        ctx.setStrategy(new PrimeDiscountStrategy());
        BigDecimal pay3 = ctx.calculatePrice(BigDecimal.valueOf(105));
        System.out.println(pay3);
    }

    static <T> void sort(T[] a, Comparator<? super T> c) {

        for (int i = 0; i < a.length - 1; i++) {

            for (int j = 0; j < a.length - 1 - i; j++) {

                if (c.compare(a[j], a[j + 1]) > 0) { // 注意这里比较两个元素的大小依赖传入的策略

                    T temp = a[j];

                    a[j] = a[j + 1];

                    a[j + 1] = temp;
                }
            }
        }
    }
}
