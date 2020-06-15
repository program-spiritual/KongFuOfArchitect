package multithreads.readWriteLock;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock保证了只有一个线程可以执行临界区代码：
 * ReadWriteLock可以解决这个问题，它保证：
 *
 * 只允许一个线程写入（其他线程既不能写入也不能读取）；
 * 没有写入时，多个线程允许同时读（提高性能）。
 */
public class Counter {
    private final Lock lock = new ReentrantLock();
    private int[] counts = new int[10];

    public void inc(int index) {
        lock.lock();
        try {
            counts[index] += 1;
        } finally {
            lock.unlock();
        }
    }

    public int[] get() {
        lock.lock();
        try {
            return Arrays.copyOf(counts, counts.length);
        } finally {
            lock.unlock();
        }
    }
}
