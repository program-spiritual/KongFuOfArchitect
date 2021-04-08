public class VariableScope {

  public static void main(String[] args) {
    //        而在语句块中定义的变量，它有一个作用域，就是从定义处开始，到语句块结束。超出了作用域引用这些变量，编译器会报错。举个例子：
    {
      int i = 0; // 变量i从这里开始定义
      {
        int x = 1; // 变量x从这里开始定义
        {
          String s = "hello"; // 变量s从这里开始定义
        } // 变量s作用域到此结束
        // 注意，这是一个新的变量s，它和上面的变量同名，
        // 但是因为作用域不同，它们是两个不同的变量:
        String s = "hi";
      } // 变量x和s作用域到此结束
    } // 变量i作用域到此结束
  }
}
