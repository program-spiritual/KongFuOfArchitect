public class IntegerArithmeticDemo2 {

  public static void main(String[] args) {
    //        int x = 2147483640;
    //        int y = 15;
    //        int sum = x + y;
    //        System.out.println(sum); // -2147483641
    //        要解决上面的问题，可以把int换成long类型，由于long可表示的整型范围更大，所以结果就不会溢出：
    long x = 2147483640;
    long y = 15;
    long sum = x + y;
    System.out.println(sum); // 2147483655
    //        简写的运算符，即+=，-=，*=，/=，它们的使用方法如下：
    int n = 3309;
    n += 100; // 3409, 相当于 n = n + 100;
    n -= 100; // 3309, 相当于 n = n - 100;
  }
}
