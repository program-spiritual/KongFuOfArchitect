public class PolymorphismDemo5 {

  //    继承可以允许子类覆写父类的方法。
  //   如果一个父类不允许子类对它的某个方法进行覆写，
  //  可以把该方法标记为final。用final修饰的方法不能被Override
  public static void main(String[] args) {
    Person14Copy p = new Person14Copy();
    //        p.name = "New Name"; // compile error!  Error:(7, 10) java: 无法为最终变量name分配值
  }
}

class Person14 {

  protected String name;

  public final String hello() {
    return "Hello, " + name;
  }
}

class Student6 extends Person14 {
  // compile error: 不允许覆写
  //    @Override
  //    public String hello() {
  //    }
}

//如果一个类不希望任何其他类继承自它，那么可以把这个类本身标记为final。用final修饰的类不能被继承：

final class Person14Copy {

  //    protected String name;
  //对于一个类的实例字段，同样可以用final修饰。用final修饰的字段在初始化后不能被修改。例如：

  public final String name = "Unamed";
}

//Error:(31, 29) java: 无法从最终Person14Copy进行继承
//class Student6Copy extends  Person14Copy{
//
//}

//可以在构造方法中初始化final字段：

class Person15 {

  public final String name;

  public Person15(String name) {
    this.name = name;
  }
}
//这种方法更为常用，因为可以保证实例一旦创建，其final字段就不可修改。
