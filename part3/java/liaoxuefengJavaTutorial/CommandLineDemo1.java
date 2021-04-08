public class CommandLineDemo1 {

  /**
   * Java程序的入口是main方法，而main方法可以接受一个命令行参数，它是一个String[]数组。
   *
   * 这个命令行参数由JVM接收用户输入并传给main方法
   * */
  public static void main(String[] args) {
    for (String arg : args) {
      System.out.println(arg);
    }
  }
}
