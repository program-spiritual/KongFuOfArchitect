import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class MultipleCatchStatementsDemo1 {

  public static void main(String[] args) {
    //        可以使用多个catch语句，每个catch分别捕获对应的Exception及其子类。
    //       JVM在捕获到异常后，会从上到下匹配catch语句，匹配到某个catch后，执行catch代码块，然后不再继续匹配。
    //
    //简单地说就是：多个catch语句只有一个能被执行。例如：
    try {
      process1();
      process2();
      process3();
    } catch (NumberFormatException e) {
      System.out.println(e);
    }
    //        存在多个catch的时候，catch的顺序非常重要：子类必须写在前面。例如：
    //        try {
    //            process1();
    //            process2();
    //            process3();
    //        } catch (UnsupportedEncodingException e) {
    //            System.out.println("Bad encoding");
    //        } catch (IOException e) {
    //            System.out.println("IO error");
    //        }
  }

  private static void process3() {}

  private static void process2() {}

  private static void process1() {}
}
