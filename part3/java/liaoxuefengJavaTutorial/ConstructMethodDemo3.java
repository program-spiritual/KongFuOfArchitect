public class ConstructMethodDemo3 {
    private String name;
    private int age;
//    如果调用new Person("Xiao Ming", 20);，会自动匹配到构造方法public Person(String, int)。
//
//    如果调用new Person("Xiao Ming");，会自动匹配到构造方法public Person(String)。
//
//    如果调用new Person();，会自动匹配到构造方法public Person()。
//    一个构造方法可以调用其他构造方法，这样做的目的是便于代码复用。调用其他构造方法的语法是this(…)：
    public ConstructMethodDemo3() {
        this("Unnamed"); // 调用另一个构造方法   ConstructMethodDemo3(String)
    }

    public ConstructMethodDemo3(String name) {
//        this.name = name;
        this(name, 18); // 调用另一个构造方法ConstructMethodDemo3(String, int)
    }

    public ConstructMethodDemo3(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public static void main(String[] args) {

    }
//    可以定义多个构造方法，在通过new操作符调用的时候，编译器通过构造方法的参数数量、位置和类型自动区分：

}
