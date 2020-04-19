public class PolymorphismDemo1 {
    public static void main(String[] args) {
//        在继承关系中，子类如果定义了一个与父类方法签名完全相同的方法，被称为覆写（Override）
    }
}
//        例如，在Person类中，我们定义了run()方法：

class Person11 {
    public void run() {
        System.out.println("Person11.run");
    }
}

//在子类Student中，覆写这个run()方法：
//Override和Overload不同的是，方法签名不同，就是Overload，Overload方法是一个新方法；方法签名相同，并且返回值也相同，就是 Override
class Student4 extends Person11 {
    @Override
    public void run() {
        System.out.println("Student4.run");
    }
    // 不是Override，因为参数不同:
    public void run(String s) {  }
    // 不是Override，因为返回值不同:
//    public int run() { return  1;}
}

//Java的实例方法调用是基于运行时的实际类型的动态调用，而非变量的声明类型。
//
//这个非常重要的特性在面向对象编程中称之为多态。它的英文拼写非常复杂：Polymorphic。