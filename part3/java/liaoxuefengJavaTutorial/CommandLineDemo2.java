public class CommandLineDemo2 {

  //    我们可以利用接收到的命令行参数，根据不同的参数执行不同的代码。例如，实现一个-version参数，打印程序版本号：
  public static void main(String[] args) {
    for (String arg : args) {
      if (arg.equals("-version")) {
        System.out.println("v 1.0");
        break;
      }
    }
  }
}
