package multithreads.create;

//sleep()传入的参数是毫秒。调整暂停时间的大小，我们可以看到main线程和t线程执行的先后顺序。
public class ThreadDemo5 {

  public static void main(String[] args) {
    System.out.println("main start...");
    Thread t = new Thread() {
      public void run() {
        System.out.println("thread run...");
        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {}
        System.out.println("thread end.");
      }
    };
    t.start();
    try {
      Thread.sleep(20);
    } catch (InterruptedException e) {}
    System.out.println("main end...");
  }
}
