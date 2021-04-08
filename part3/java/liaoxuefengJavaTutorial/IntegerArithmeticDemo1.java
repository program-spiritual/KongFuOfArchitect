public class IntegerArithmeticDemo1 {

  //    Java的整数运算遵循四则运算规则，可以使用任意嵌套的小括号。四则运算规则和初等数学一致。例如：
  public static void main(String[] args) {
    int i = (100 + 200) * (99 - 88); // 3300
    int n = 7 * (5 + (i - 9)); // 23072
    System.out.println(i);
    System.out.println(n);
    //        而且整数运算永远是精确的，即使是除法也是精确的，因为两个整数相除只能得到结果的整数部分：
    int x = 12345 / 67; // 184
    int y = 12345 % 67; // 12345÷67的余数是17
    //        整数的除法对于除数为0时运行时将报错，但编译不会报错。
  }
}
