public class IntefaceDemo1 {

  public static void main(String[] args) {
    Person18 p18 = new Student9("jim");
    ((Student9) p18).sayhello();
  }
}

//在抽象类中，抽象方法本质上是定义接口规范：即规定高层类的接口，从而保证所有子类都有相同的接口实现，这样，多态就能发挥出威力。
//
//如果一个抽象类没有字段，所有方法全部都是抽象方法：

//abstract class Person {
//    public abstract void run();
//    public abstract String getName();
//}
//就可以把该抽象类改写为接口：interface。

//在Java中，使用interface可以声明一个接口：

interface Person18 {
  void run();

  String getName();
}

interface Hello2 {
  void sayhello();
}

//所谓interface，就是比抽象类还要抽象的纯抽象接口，因为它连字段都不能有。
//因为接口定义的所有方法默认都是public abstract的，所以这两个修饰符不需要写出来（写不写效果都一样）。
//
//当一个具体的class去实现一个interface时，需要使用implements关键字。举个例子：

class Student9 implements Person18, Hello2 {

  private String name;

  public Student9(String name) {
    this.name = name;
  }

  @Override
  public void run() {
    System.out.println(this.name + " run");
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public void sayhello() {
    System.out.println("Hello" + this.name);
  }
}
//我们知道，在Java中，一个类只能继承自另一个类，不能从多个类继承。但是，一个类可以实现多个interface，例如：
