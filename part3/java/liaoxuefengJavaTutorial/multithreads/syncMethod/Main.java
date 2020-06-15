package multithreads.syncMethod;

public class Main {
    public static void main(String[] args) {
//        让线程自己选择锁对象往往会使得代码逻辑混乱，也不利于封装。更好的方法是把synchronized逻辑封装起来。例如，我们编写一个计数器如下：
//        这样一来，线程调用add()、dec()方法时，它不必关心同步逻辑，因为synchronized代码块在add()、dec()方法内部。
//       并且，我们注意到，synchronized锁住的对象是this，即当前实例，这又使得创建多个Counter实例的时候，它们之间互不影响，可以并发执行：
        var c1 = new Counter();
        var c2 = new Counter();

// 对c1进行操作的线程:
        new Thread(() -> {
            c1.add();
        }).start();
        new Thread(() -> {
            c1.dec();
        }).start();

// 对c2进行操作的线程:
        new Thread(() -> {
            c2.add();
        }).start();
        new Thread(() -> {
            c2.dec();
        }).start();
    }

    /**
     * 如果一个类被设计为允许多线程正确访问，我们就说这个类就是“线程安全”的（thread-safe），
     *
     * 上面的Counter类就是线程安全的。Java标准库的java.lang.StringBuffer也是线程安全的。
     *
     * 还有一些不变类，例如String，Integer，LocalDate，它们的所有成员变量都是final，
     *
     * 多线程同时访问时只能读不能写，这些不变类也是线程安全的。
     *
     * 最后，类似Math这些只提供静态方法，没有成员变量的类，也是线程安全的。
     *
     * 用synchronized修饰的方法就是同步方法，它表示整个方法都必须用this实例加锁。
     *
     对static方法添加synchronized，锁住的是该类的Class实例。上述synchronized static方法实际上相当于
     *public class Counter {
     *     public static void test(int n) {
     *         synchronized(Counter.class) {
     *             ...
     *         }
     *     }
     * }
     * */
}
