public class StringBuilderDemo1 {

  public static void main(String[] args) {
    //        为了能高效拼接字符串，Java标准库提供了StringBuilder，它是一个可变对象，可以预分配缓冲区，这样，往StringBuilder中新增字符时，不会创建新的临时对象：
    StringBuilder sb = new StringBuilder(1024);
    for (int i = 0; i < 1000; i++) {
      sb.append(',');
      sb.append(i);
    }
    String s = sb.toString();
    System.out.println(s);
    //        StringBuilder还可以进行链式操作：
    var sb2 = new StringBuilder(1024);
    sb2
      .append("Mr ")
      .append("James")
      .append("!")
      .append("!")
      .insert(0, "Hello ,");
    System.out.println(sb2);
  }
}
