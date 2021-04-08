package abstractclass;

public class AbstractClassDemo3 {

  public static void main(String[] args) {}
}
//当我们定义了抽象类Person，以及具体的Student、Teacher子类的时候，我们可以通过抽象类Person类型去引用具体的子类的实例：
//Person s = new Student();
//Person t = new abstractclass.Teacher();
//这种引用抽象类的好处在于，我们对其进行方法调用，并不关心Person类型变量的具体子类型：
//
//// 不关心Person变量的具体子类型:
//s.run();
//t.run();
//同样的代码，如果引用的是一个新的子类，我们仍然不关心具体类型：
//
//// 同样不关心新的子类是如何实现run()方法的：
//Person e = new Employee();
//e.run();
//这种尽量引用高层类型，避免引用实际子类型的方式，称之为面向抽象编程。
//
//面向抽象编程的本质就是：
//
//上层代码只定义规范（例如：abstract class Person）；
//
//不需要子类就可以实现业务逻辑（正常编译）；
//
//具体的业务逻辑由不同的子类实现，调用者并不关心。
