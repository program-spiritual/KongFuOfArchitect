import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class FinallyStatementsDemo1 {

  public static void main(String[] args) {
    //        无论是否有异常发生，如果我们都希望执行一些语句，例如清理工作，怎么写？
    //
    //可以把执行语句写若干遍：正常执行的放到try中，每个catch再写一遍。例如：
    //        那么如何消除这些重复的代码？Java的try ... catch机制还提供了finally语句，finally语句块保证有无错误都会执行。上述代码可以改写如下
    try {
      process1();
      process2();
      process3();
    } catch (UnsupportedEncodingException e) {
      System.out.println("Bad encoding");
    } catch (IOException e) {
      System.out.println("IO error");
    } finally {
      System.out.println("END");
    }
  }

  private static void process3() throws UnsupportedEncodingException {
    throw new UnsupportedEncodingException("错误");
  }

  private static void process2() {}

  private static void process1() {}
}
//注意finally有几个特点：
//
//finally语句不是必须的，可写可不写；
//finally总是最后执行。
//如果没有发生异常，就正常执行try { ... }语句块，然后执行finally。
//如果发生了异常，就中断执行try { ... }语句块，然后跳转执行匹配的catch语句块，最后执行finally。
//
//可见，finally是用来保证一些代码必须执行的。
//
//某些情况下，可以没有catch，只使用try ... finally结构。例如：
//某些情况下，可以没有catch，只使用try ... finally结构。例如：
//
//void process(String file) throws IOException {
//    try {
//        ...
//    } finally {
//        System.out.println("END");
//    }
//}
