package abstractclass;

public class AbstractClassDemo1 {
    //如果父类Person的run()方法没有实际意义，能否去掉方法的执行语句？
//    答案是不行，会导致编译错误，因为定义方法的时候，必须实现方法的语句。
//
//能不能去掉父类的run()方法？
//
//答案还是不行，因为去掉父类的run()方法，就失去了多态的特性。例如，runTwice()就无法编译：
//    public void runTwice(Person p) {
//    p.run(); // Person没有run()方法，会导致编译错误
//    p.run();
//}
//    如果一个class定义了方法，但没有具体执行代码，这个方法就是抽象方法，抽象方法用abstract修饰。
//
//因为无法执行抽象方法，因此这个类也必须申明为抽象类（abstract class）。
    public static void main(String[] args) {
//        使用abstract修饰的类就是抽象类。我们无法实例化一个抽象类：
//        abstractclass.Person16 p = new abstractclass.Person16(); // 编译错误 Error:(17, 22) java: Person16是抽象的; 无法实例化
//        无法实例化的抽象类有什么用？
//
//因为抽象类本身被设计成只能用于被继承，因此，抽象类可以强迫子类实现其定义的抽象方法，否则编译会报错。因此，抽象方法实际上相当于定义了“规范”
    }
}

//必须把Person类本身也声明为abstract，才能正确编译它：
abstract class Person16 {
    //    从Person类派生的Student和Teacher都可以覆写run()方法。
//

    //    如果父类的方法本身不需要实现任何功能，仅仅是为了定义方法签名，目的是让子类去覆写它，那么，可以把父类的方法声明为抽象方法：
    public abstract void run();
//    public void run() ; // Error:(14, 17) java: 缺少方法主体, 或声明抽象
}


//由于多态的存在，每个子类都可以覆写父类的方法，例如：

class Student7 extends Person16 {
    @Override
    public void run() {
    }
}

class Teacher extends Person16 {
    @Override
    public void run() {
    }
}