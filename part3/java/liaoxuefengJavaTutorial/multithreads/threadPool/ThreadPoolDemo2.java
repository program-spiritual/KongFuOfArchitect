package multithreads.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo2 {

  public static void main(String[] args) {
    int min = 4;
    int max = 10;
    ExecutorService es = new ThreadPoolExecutor(
      min,
      max,
      60L,
      TimeUnit.SECONDS,
      new SynchronousQueue<Runnable>()
    );
  }
}
