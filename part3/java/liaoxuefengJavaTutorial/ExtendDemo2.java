public class ExtendDemo2 {

  public static void main(String[] args) {
    //        继承有个特点，就是子类无法访问父类的private字段或者private方法。
    //       例如，Student类就无法访问Person类的name和age字段：
  }
}

class Person10 {

  protected String name;
  protected int age;
  protected int score;
}

class Student extends Person10 {

  public String hello() {
    //        return "Hello, " + name; // 编译错误：无法访问name字段
    //        这使得继承的作用被削弱了。为了让子类可以访问父类的字段，我们需要把private改为protected。用protected修饰的字段可以被子类访问：
    return "Hello" + name;
    //        因此，protected关键字可以把字段和方法的访问权限控制在继承树内部，一个protected字段和方法可以被其子类，以及子类的子类所访问，后面我们还会详细讲解。
  }
}
