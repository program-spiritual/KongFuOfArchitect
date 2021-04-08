package multithreads.readWriteLock;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CounterV2 {

  private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
  private final Lock rlock = readWriteLock.readLock();
  private final Lock wlock = readWriteLock.writeLock();
  private int[] counts = new int[10];

  public void inc(int index) {
    wlock.lock();
    try {
      counts[index] += 1;
    } finally {
      wlock.unlock();
    }
  }

  public int[] get() {
    rlock.lock();
    try {
      return Arrays.copyOf(counts, counts.length);
    } finally {
      rlock.unlock();
    }
  }
}
