package booleanDemo;

public class BooleanArithmeticDemo1 {

  /**
   * 关系运算符的优先级从高到低依次是：
   *
   * !
   * >，>=，<，<=
   * ==，!=
   * &&
   * ||
   * */
  public static void main(String[] args) {
    //布尔运算的一个重要特点是短路运算。如果一个布尔运算的表达式能提前确定结果，则后续的计算不再执行，直接返回结果。
    //        因为false && x的结果总是false，无论x是true还是false，因此，与运算在确定第一个值为false后，不再继续计算，而是直接返回false。
    boolean b = 5 < 3;
    boolean result = b && (5 / 0 > 0);
    System.out.println(result);
  }
}
