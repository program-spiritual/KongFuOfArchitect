public class IntegerArithmeticDemo3 {

  public static void main(String[] args) {
    int n = 3300;
    n++; // 3301, 相当于 n = n + 1;
    n--; // 3300, 相当于 n = n - 1;
    int y = 100 + (++n); // 不要这么写
    System.out.println(y);
    //        注意++写在前面和后面计算结果是不同的，++n表示先加1再引用n，n++表示先引用n再加1。不建议把++运算混入到常规运算中，容易自己把自己搞懵了
  }
}
