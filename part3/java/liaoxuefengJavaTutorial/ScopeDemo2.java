public class ScopeDemo2 {

  public static void main(String[] args) {
    Inner inner = new ScopeDemo2.Inner();
    inner.hi();
  }

  // private方法:
  private static void hello() {
    System.out.println("private hello!");
  }

  //由于Java支持嵌套类，如果一个类内部还定义了嵌套类，那么，嵌套类拥有访问private的权限：
  //    定义在一个class内部的class称为嵌套类（nested class），Java支持好几种嵌套类。
  //    静态内部类
  static class Inner {

    public void hi() {
      ScopeDemo2.hello();
    }
  }
}
