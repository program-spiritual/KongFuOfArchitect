public class FloatDemo {

  public FloatDemo() {}

  //因为小数用科学计数法表示的时候，小数点是可以“浮动”的，如1234.5可以表示成12.345x102，也可以表示成1.2345x103，所以称为浮点数。
  public static void main(String[] args) {
    float f1 = 3.14f;
    float f2 = 3.14e38f; // 科学计数法表示的3.14x10^38
    double d = 1.79e308;
    double d2 = -1.79e308;
    double d3 = 4.9e-324; // 科学计数法表示的4.9x10^-324
  }
  //    对于float类型，需要加上f后缀。
  //
  //浮点数可表示的范围非常大，float类型可最大表示3.4x10^38，而double类型可最大表示1.79x10^308。
}
