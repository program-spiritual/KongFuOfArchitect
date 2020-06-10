package multithreads.daemonThreads;

public class daemonThreadsDemo2 {
    public static void main(String[] args) throws InterruptedException{
        var add = new AddThread2();
        var dec = new DecThread2();
        add.start();
        dec.start();
        add.join();
        dec.join();
        System.out.println(Counter2.count);
    }
}


class Counter2 {
    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();
    public static int count = 0;
}

class AddThread2 extends Thread {
    public void run() {
        for (int i=0; i<10000; i++) {
            synchronized(Counter2.lock1) {
                Counter2.count += 1;
            }
        }
    }
}

class DecThread2 extends Thread {
    public void run() {
        for (int i=0; i<10000; i++) {
            synchronized(Counter2.lock2) {
                Counter2.count -= 1;
            }
        }
    }
}