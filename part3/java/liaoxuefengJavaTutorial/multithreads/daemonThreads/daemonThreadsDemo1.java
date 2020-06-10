package multithreads.daemonThreads;
/**
 * 它表示用Counter.lock实例作为锁，两个线程在执行各自的synchronized(Counter.lock) { ... }代码块时，必须先获得锁，才能进入代码块进行。执行结束后，在synchronized语句块结束会自动释放锁。这样一来，对Counter.count变量进行读写就不可能同时进行。上述代码无论运行多少次，最终结果都是0。
 *
 * 使用synchronized解决了多线程同步访问共享变量的正确性问题。但是，它的缺点是带来了性能下降。因为synchronized代码块无法并发执行。此外，加锁和解锁需要消耗一定的时间，所以，synchronized会降低程序的执行效率。
 *
 * */
public class daemonThreadsDemo1 {
    public static void main(String[] args) throws InterruptedException{
        var add = new AddThread();
        var dec = new DecThread();
        add.start();
        dec.start();
        add.join();
        dec.join();
        System.out.println(Counter.count);
    }
}




class Counter {
    public static final Object lock = new Object();
    public static int count = 0;
}

class AddThread extends Thread {
    public void run() {
        for (int i=0; i<10000; i++) {
//            Java程序使用synchronized关键字对一个对象进行加锁：
            synchronized(Counter.lock) {
                Counter.count += 1;
            }
        }
    }
}

class DecThread extends Thread {
    public void run() {
        for (int i=0; i<10000; i++) {
            synchronized(Counter.lock) {
                Counter.count -= 1;
            }
        }
    }
}