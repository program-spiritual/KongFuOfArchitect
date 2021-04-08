package multithreads.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 那么我们就可以把很多小任务让一组线程来执行，
 * <p>
 * 而不是一个任务对应一个新线程。
 * <p>
 * 这种能接收大量小任务并进行分发处理的就是线程池。
 * 因为ExecutorService只是接口，Java标准库提供的几个常用实现类有：
 * <p>
 * FixedThreadPool：线程数固定的线程池；
 * CachedThreadPool：线程数根据任务动态调整的线程池；
 * SingleThreadExecutor：仅单线程执行的线程池。
 */
public class Main {

  public static void main(String[] args) {
    // 创建固定大小的线程池:
    ExecutorService executor = Executors.newFixedThreadPool(3);
    // 提交任务:
    //        executor.submit(task1);
    //        executor.submit(task2);
    //        executor.submit(task3);
    //        executor.submit(task4);
    //        executor.submit(task5);
  }
}
