public class StringAndEncodeDemo3 {

  public static void main(String[] args) {
    //        String类还提供了多种方法来搜索子串、提取子串。常用的方法有：
    System.out.println("Hello".contains("ll"));
    //        注意到contains()方法的参数是CharSequence而不是String，因为CharSequence是String的父类。
    //        搜索字符串更多实例
    "Hello".indexOf("l"); // 2
    "Hello".lastIndexOf("l"); // 3
    "Hello".startsWith("He"); // true
    "Hello".endsWith("lo"); // true
    //        提取子串的例子：
    "Hello".substring(2); // "llo"
    "Hello".substring(2, 4); // "ll"
  }
}
