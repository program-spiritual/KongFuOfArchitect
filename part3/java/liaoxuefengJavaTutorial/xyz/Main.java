package xyz;

import abc.Hello;

public class Main {

  public static void main(String[] args) {
    // Main可以访问Hello
    Hello h = new Hello();
    h.hello();
    //        h.hi(); Error:(10, 10) java: hi() 在 abc.Hello 中是 private 访问控制
    //        实际上，确切地说，private访问权限被限定在class的内部，而且与方法声明顺序无关。
    //       推荐把private方法放到后面，因为public方法定义了类对外提供的功能，阅读代码的时候，应该先关注public方法：
  }
}
