package io.printstream;

public class Main {

  public static void main(String[] args) {
    //        我们经常使用的System.out.println()实际上就是使用PrintStream打印各种数据。
    //       其中，System.out是系统默认提供的PrintStream，表示标准输出：
    System.out.print(12345); // 输出12345
    System.out.print(new Object()); // 输出类似java.lang.Object@3c7a835a
    System.out.println("Hello"); // 输出Hello并换行
    //        PrintStream和OutputStream相比，除了添加了一组print()/println()方法，
    //       可以打印各种数据类型，比较方便外，它还有一个额外的优点，就是不会抛出IOException，
    //       这样我们在编写代码的时候，就不必捕获IOException。
  }
}
