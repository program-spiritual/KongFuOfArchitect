public class ConstructMethodDemo1 {
    public static void main(String[] args) {
//        能否在创建对象实例时就把内部字段全部初始化为合适的值？
    }
}

class Person7 {
//    没有在构造方法中初始化字段时，
//   引用类型的字段默认是null，
//  数值类型的字段用默认值，int类型默认值是0，布尔类型默认值是false：
    private String name;
    private int age;
// 由于构造方法是如此特殊，所以构造方法的名称就是类名。
//构造方法的参数没有限制，在方法内部，也可以编写任意语句。
//但是，和普通方法相比，构造方法没有返回值（也没有void），调用构造方法，必须用new操作符。
//     如果一个类没有定义构造方法，编译器会自动为我们生成一个默认构造方法，它没有参数，也没有执行语句，类似这样：
//
//class Person {
//    public Person() {
//    }
//}
//     特别注意的是，如果我们自定义了一个构造方法，那么，编译器就不再自动创建默认构造方法
    public Person7(String name, int age) {
        this.name = name;
        this.age = age;
    }

//     如果既要能使用带参数的构造方法，又想保留不带参数的构造方法，那么只能把两个构造方法都定义出来：
    public Person7()  {

    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}