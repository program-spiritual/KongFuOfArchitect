public class EnumerationClassDemo2 {
    public static void main(String[] args) {
        Integer day = 1;
//        if (day == Weekday2.SUN) { // ok! Error:(4, 17) java: 不可比较的类型: java.lang.Integer和Weekday2
//        }
        if (day.equals(Weekday2.SUN)) { // ok, but more code!
        }
    }
}



//enum定义的枚举类是一种引用类型。前面我们讲到，引用类型比较，要使用equals()方法，
//如果使用==比较，它比较的是两个引用类型的变量是否是同一个对象。
//因此，引用类型比较，要始终使用equals()方法，但enum类型可以例外。
//这是因为enum类型的每个常量在JVM中只有一个唯一实例，所以可以直接用==比较：