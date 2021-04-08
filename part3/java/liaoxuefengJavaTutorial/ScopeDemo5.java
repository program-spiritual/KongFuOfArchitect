public class ScopeDemo5 {

  /**
   * 如果不确定是否需要public，就不声明为public，即尽可能少地暴露对外的字段和方法。
   *
   * 把方法定义为package权限有助于测试，因为测试类和被测试类只要位于同一个package，测试代码就可以访问被测试类的package权限方法。
   *
   * 一个.java文件只能包含一个public类，但可以包含多个非public类。如果有public类，文件名必须和public类的名字相同。
   * */
  public static void main(String[] args) {}
}

//用final修饰class可以阻止被继承：
final class FinalDemo1 {

  private int n = 0;
  //用final修饰field可以阻止被重新赋值：
  private final int n1 = 0;

  protected void hi(int t) {
    long i = t;
  }

  //    用final修饰method可以阻止被子类覆写：
  // 无法被覆写:
  protected final void hello() {}

  //    用final修饰局部变量可以阻止被重新赋值：
  protected void say(final int t) {
    //        t = 1; // error!
  }
}
