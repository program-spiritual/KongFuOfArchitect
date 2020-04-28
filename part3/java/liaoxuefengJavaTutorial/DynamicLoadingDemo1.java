public class DynamicLoadingDemo1 {
//    JVM在执行Java程序的时候，并不是一次性把所有用到的class全部加载到内存，而是第一次需要用到class时才加载。例如：
    public static void main(String[] args) {
        if (args.length > 0) {
            create(args[0]);
        }
    }
    static void create(String name) {
        Person p = new Person(name);
    }

//    当执行Main.java时，由于用到了Main，因此，JVM首先会把Main.class加载到内存。
//   然而，并不会加载Person.class，除非程序执行到create()方法，
//  JVM发现需要加载Person类时，才会首次加载Person.class。
// 如果没有执行create()方法，那么Person.class根本就不会被加载。
//
//这就是JVM动态加载class的特性。
}
