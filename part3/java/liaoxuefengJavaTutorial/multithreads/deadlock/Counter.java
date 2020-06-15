package multithreads.deadlock;

public class Counter {
    private int count = 0;
    private int another;
    private int value;

    public void add(int m) {
        Object lockA = new Object();
        synchronized(lockA) { // 获得lockA的锁
            this.value += m;
            Object lockB = new Object();
            synchronized(lockB) { // 获得lockB的锁
                this.another += m;
            } // 释放lockB的锁
        } // 释放lockA的锁
    }

    public void dec(int m) {
        Object lockB = new Object();
        synchronized(lockB) { // 获得lockB的锁
            this.another -= m;
            Object lockA = new Object();
            synchronized(lockA) { // 获得lockA的锁
                this.value -= m;
            } // 释放lockA的锁
        } // 释放lockB的锁
    }
}
