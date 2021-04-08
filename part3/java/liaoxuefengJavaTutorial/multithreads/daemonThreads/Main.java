package multithreads.daemonThreads;

import java.time.LocalTime;

public class Main {

  public static void main(String[] args) {
    //        有一种线程的目的就是无限循环，例如，一个定时触发任务的线程：
    while (true) {
      System.out.println(LocalTime.now());
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        break;
      }
    }
  }
}
