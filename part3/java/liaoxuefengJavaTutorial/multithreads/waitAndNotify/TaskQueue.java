package multithreads.waitAndNotify;

import java.util.LinkedList;
import java.util.Queue;

public class TaskQueue {

  Queue<String> queue = new LinkedList<>();

  public synchronized void addTask(String s) {
    //        如何让等待的线程被重新唤醒，然后从wait()方法返回？答案是在相同的锁对象上调用notify()方法

    this.queue.add(s);
    //        this.notify();
    this.notifyAll();
  }

  public synchronized String getTask() {
    while (queue.isEmpty()) {
      try {
        this.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    return queue.remove();
  }
}
