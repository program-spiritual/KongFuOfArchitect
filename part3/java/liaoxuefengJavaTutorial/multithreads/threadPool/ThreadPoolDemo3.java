package multithreads.threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo3 {

  public static void main(String[] args) {
    ScheduledExecutorService ses = Executors.newScheduledThreadPool(4);
    // 1秒后执行一次性任务:
    ses.schedule(new Task("one-time"), 1, TimeUnit.SECONDS);
    // 2秒后开始执行定时任务，每3秒执行:
    ses.scheduleAtFixedRate(new Task("fixed-rate"), 2, 3, TimeUnit.SECONDS);
    // 2秒后开始执行定时任务，以3秒为间隔执行:
    ses.scheduleWithFixedDelay(new Task("fixed-delay"), 2, 3, TimeUnit.SECONDS);
    //        FixedRate是指任务总是以固定时间间隔触发，不管任务执行多长时间
    //        FixedDelay是指，上一次任务执行完毕后，等待固定的时间间隔，再执行下一次任务：
  }
}
