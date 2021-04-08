package multithreads.condition;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Condition时，引用的Condition对象必须从Lock实例的newCondition()返回，这样才能获得一个绑定了Lock实例的Condition实例。
 *
 * Condition提供的await()、signal()、signalAll()原理和synchronized锁对象的wait()、notify()、notifyAll()是一致的，并且其行为也是一样的：
 *
 * await()会释放当前锁，进入等待状态；
 *
 * signal()会唤醒某个等待线程；
 *
 * signalAll()会唤醒所有等待线程；
 *
 * 唤醒线程从await()返回后需要重新获得锁。
 * */
public class TaskQueue {

  private final Lock lock = new ReentrantLock();
  private final Condition condition = lock.newCondition();
  private Queue<String> queue = new LinkedList<>();

  public void addTask(String s) {
    lock.lock();
    try {
      queue.add(s);
      condition.signalAll();
    } finally {
      lock.unlock();
    }
  }

  public String getTask() {
    lock.lock();
    try {
      while (queue.isEmpty()) {
        try {
          condition.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      return queue.remove();
    } finally {
      lock.unlock();
    }
  }
}
