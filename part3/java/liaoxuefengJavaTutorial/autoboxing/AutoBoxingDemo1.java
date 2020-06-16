package autoboxing;

public class AutoBoxingDemo1 {
    public static void main(String[] args) {
        int i = 100;
        Integer n = Integer.valueOf(i);
        int x = n.intValue();
//        所以，Java编译器可以帮助我们自动在int和Integer之间转型：
        Integer n2 = 100; // 编译器自动使用Integer.valueOf(int)
        int x2 = n; // 编译器自动使用Integer.intValue()
//        种直接把int变为Integer的赋值写法，称为自动装箱（Auto Boxing），反过来，把Integer变为int的赋值写法，称为自动拆箱（Auto Unboxing）。
//
//注意：自动装箱和自动拆箱只发生在编译阶段，目的是为了少写代码。
//        装箱和拆箱会影响代码的执行效率，因为编译后的class代码是严格区分基本类型和引用类型的。并且，自动拆箱执行时可能会报NullPointerException：

        Integer n3 = null;
        int i3 = n3;  // Exception in thread "main" java.lang.NullPointerException
    }
}
