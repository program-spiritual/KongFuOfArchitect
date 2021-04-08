public class StringAndEncodeDemo2 {

  public static void main(String[] args) {
    //        当我们想要比较两个字符串是否相同时，要特别注意，我们实际上是想比较字符串的内容是否相同。必须使用equals()方法而不能用==。
    String s1 = "hello";
    String s2 = "hello";
    System.out.println(s1 == s2);
    System.out.println(s1.equals(s2));
    //        从表面上看，两个字符串用==和equals()比较都为true，
    //       但实际上那只是Java编译器在编译期，会自动把所有相同的字符串当作一个对象放入常量池，
    //      自然s1和s2的引用就是相同的。

    //        换一种写法
    String s3 = "hello";
    String s4 = "HELLO".toLowerCase();
    System.out.println(s3 == s4);
    System.out.println(s3.equals(s4));
    //        结论：两个字符串比较，必须总是使用equals()方法。
    //
    //要忽略大小写比较，使用equalsIgnoreCase()方法。
  }
}
