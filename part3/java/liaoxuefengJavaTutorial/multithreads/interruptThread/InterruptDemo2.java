package multithreads.interruptThread;

public class InterruptDemo2 {

  public static void main(String[] args) throws InterruptedException {
    TagThread t = new TagThread();
    t.start();
    Thread.sleep(100);
    t.running = false; // 标志位置为false
  }
}

/**
 * 注意到HelloThread的标志位boolean running是一个线程间共享的变量。
 * 线程间共享变量需要使用volatile关键字标记，
 * 确保每个线程都能读取到更新后的变量值。
 *
 * 为什么要对线程间共享的变量用关键字volatile声明？这涉及到Java的内存模型。
 * 在Java虚拟机中，变量的值保存在主内存中，
 * 但是，当线程访问变量时，它会先获取一个副本，并保存在自己的工作内存中。
 * 如果线程修改了变量的值，虚拟机会在某个时刻把修改后的值回写到主内存，但是，这个时间是不确定的！
 *
 *
 * 这会导致如果一个线程更新了某个变量，另一个线程读取的值可能还是更新前的。
 * 例如，主内存的变量a = true，线程1执行a = false时，它在此刻仅仅是把变量a的副本变成了false，主内存的变量a还是true，
 * 在JVM把修改后的a回写到主内存之前，其他线程读取到的a的值仍然是true，这就造成了多线程之间共享的变量不一致。
 *
 * 因此，volatile关键字的目的是告诉虚拟机：
 *
 * 每次访问变量时，总是获取主内存的最新值；
 * 每次修改变量后，立刻回写到主内存。
 * volatile关键字解决的是可见性问题：当一个线程修改了某个共享变量的值，其他线程能够立刻看到修改后的值。
 *
 * 如果我们去掉volatile关键字，运行上述程序，发现效果和带volatile差不多，这是因为在x86的架构下，
 * JVM回写主内存的速度非常快，但是，换成ARM的架构，就会有显著的延迟。
 *
 * */
class TagThread extends Thread {

  public volatile boolean running = true;

  public void run() {
    int n = 0;
    while (running) {
      n++;
      System.out.println(n + " hello!");
    }
    System.out.println("end!");
  }
}
