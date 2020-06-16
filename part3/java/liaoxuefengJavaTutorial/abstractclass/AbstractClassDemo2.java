package abstractclass;

public class AbstractClassDemo2 {
    public static void main(String[] args) {
        Person17 p = new Student8();
        p.run();
    }
}

//例如，Person类定义了抽象方法run()，那么，在实现子类Student的时候，就必须覆写run()方法：
abstract class Person17 {
    public abstract void run();
}

class Student8 extends Person17 {
    @Override
    public void run() {
        System.out.println("Student.run");
    }
}
