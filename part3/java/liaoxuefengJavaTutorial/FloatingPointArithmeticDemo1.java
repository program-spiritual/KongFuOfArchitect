public class FloatingPointArithmeticDemo1 {

  public FloatingPointArithmeticDemo1() {}

  //浮点数运算和整数运算相比，只能进行加减乘除这些数值计算，不能做位运算和移位运算。
  //
  //在计算机中，浮点数虽然表示的范围大，但是，浮点数有个非常重要的特点，就是浮点数常常无法精确表示。
  //    浮点数0.1在计算机中就无法精确表示，因为十进制的0.1换算成二进制是一个无限循环小数，
  //   很显然，无论使用float还是double，都只能存储一个0.1的近似值。但是，0.5这个浮点数又可以精确地表示。
  public static void main(String[] args) {
    double x = 1.0 / 10;
    double y = 1 - 9.0 / 10;
    // 观察x和y是否相等:
    System.out.println(x);
    System.out.println(y);
  }
}
