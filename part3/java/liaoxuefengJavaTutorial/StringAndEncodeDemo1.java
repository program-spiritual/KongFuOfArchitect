public class StringAndEncodeDemo1 {

  //    Java字符串的一个重要特点就是字符串不可变。这种不可变性是通过内部的private final char[]字段，以及没有任何修改char[]的方法实现的
  public static void main(String[] args) {
    String s = "Hello";
    System.out.println(s);
    s = s.toUpperCase();
    System.out.println(s);
  }
}
