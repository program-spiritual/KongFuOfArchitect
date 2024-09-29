package singleton;

// 嵌套类不能访问外部类的非静态成员变量和方法。如果需要访问外部类的非静态成员，可以使用内部类（Inner Class）代替
public class Singleton3 {
  private Singleton3() {
  }
  // use nested class to hold the instance
  private static class SingletonHolder {
    private static Singleton3 instance = new Singleton3();
  }
  public static Singleton3 getInstance() {
    return SingletonHolder.instance;
  }
}
