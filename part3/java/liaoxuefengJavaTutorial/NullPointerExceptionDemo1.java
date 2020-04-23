public class NullPointerExceptionDemo1 {
    public static void main(String[] args) {
//        在所有的RuntimeException异常中，Java程序员最熟悉的恐怕就是NullPointerException了。
//
//NullPointerException即空指针异常，俗称NPE。如果一个对象为null，调用其方法或访问其字段就会产生NullPointerException，这个异常通常是由JVM抛出的，例如：
        String s = null;
        System.out.println(s.toLowerCase());
//        指针这个概念实际上源自C语言，Java语言中并无指针。我们定义的变量实际上是引用，Null Pointer更确切地说是Null Reference，不过两者区别不大。
    }
}
