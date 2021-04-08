public class ConstructMethodDemo2 {

  public static void main(String[] args) {}
}

/**
 * 在Java中，创建对象实例的时候，按照如下顺序进行初始化：
 *
 * 先初始化字段，例如，int age = 10;表示字段初始化为10，double salary;表示字段默认初始化为0，String name;表示引用类型字段默认初始化为null；
 *
 * 执行构造方法的代码进行初始化。
 *
 * 因此，构造方法的代码由于后运行，所以，new Person("Xiao Ming", 12)的字段值最终由构造方法的代码确定。
 * */
class Person8 {

  private String name = "Unamed";
  private int age = 10;

  public Person8(String name, int age) {
    this.name = name;
    this.age = age;
  }
}
