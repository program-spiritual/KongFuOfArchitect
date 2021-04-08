package abc;

public class Main {

  void foo() {
    // 可以访问package权限的类:
    Hello2 h = new Hello2();
    // 可以调用package权限的方法:
    h.hi();
  }

  //    注意，包名必须完全一致，包没有父子关系，com.apache和com.apache.abc是不同的包。
  public static void main(String[] args) {}
}
