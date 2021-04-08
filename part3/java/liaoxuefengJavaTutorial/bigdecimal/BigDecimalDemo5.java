package bigdecimal;

import java.math.BigDecimal;

public class BigDecimalDemo5 {

  public static void main(String[] args) {
    //        在比较两个BigDecimal的值是否相等时，要特别注意，
    //       使用equals()方法不但要求两个BigDecimal的值相等，
    //      还要求它们的scale()相等
    BigDecimal d1 = new BigDecimal("123.456");
    BigDecimal d2 = new BigDecimal("123.45600");
    System.out.println(d1.equals(d2)); // false,因为scale不同
    System.out.println(d1.equals(d2.stripTrailingZeros())); // true,因为d2去除尾部0后scale变为2
    System.out.println(d1.compareTo(d2)); // 0
    //        必须使用compareTo()方法来比较，它根据两个值的大小分别返回负数 -1、正数1 和0，分别表示小于、大于和等于

    //        总是使用compareTo()比较两个BigDecimal的值，不要使用equals()！

    //        BigDecimal用于表示精确的小数，常用于财务计算；
    //
    //比较BigDecimal的值是否相等，必须使用compareTo()而不能使用equals()。
  }
}
