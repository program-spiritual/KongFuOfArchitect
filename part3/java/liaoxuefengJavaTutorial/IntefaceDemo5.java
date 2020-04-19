public class IntefaceDemo5 {
    public static void main(String[] args) {
        Person20 p = new Student10("Xiao Ming");
        p.run();
    }
}

//在接口中，可以定义default方法。例如，把Person接口的run()方法改为default方法：
//实现类可以不必覆写default方法。default方法的目的是，当我们需要给接口新增一个方法时，会涉及到修改全部子类。
//如果新增的是default方法，那么子类就不必全部修改，只需要在需要覆写的地方去覆写新增方法。
//
//default方法和抽象类的普通方法是有所不同的。因为interface没有字段，default方法无法访问字段，而抽象类的普通方法可以访问实例字段。
interface Person20 {
    String getName();
    default void run() {
        System.out.println(getName() + " run");
    }
}

class Student10 implements Person20 {
    private String name;

    public Student10(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
