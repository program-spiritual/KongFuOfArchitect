package multithreads.threadSynchronization;

/***
 * 当多个线程同时运行时，线程的调度由操作系统决定，程序本身无法决定。
 * 因此，任何一个线程都有可能在任何指令处被操作系统暂停，然后在某个时间段后继续执行。
 *
 * 这个时候，有个单线程模型下不存在的问题就来了：如果多个线程同时读写共享变量，会出现数据不一致的问题。
 *
 * */
public class Main {

  public static void main(String[] args) throws InterruptedException {
    var add = new AddThread();
    var dec = new DecThread();
    add.start();
    dec.start();
    add.join();
    dec.join();
    System.out.println(Counter.count);
    /***
     * 上面的代码很简单，两个线程同时对一个int变量进行操作，一个加10000次，一个减10000次，最后结果应该是0，但是，每次运行，结果实际上都是不一样的。
     *
     * 这是因为对变量进行读取和写入时，结果要正确，必须保证是原子操作。原子操作是指不能被中断的一个或一系列操作。
     *
     * 例如，对于语句：
     *
     * n = n + 1;
     * 看上去是一行语句，实际上对应了3条指令：
     *
     * ILOAD
     * IADD
     * ISTORE
     * */
  }
}

class Counter {

  public static int count = 0;
}

class AddThread extends Thread {

  public void run() {
    for (int i = 0; i < 10000; i++) {
      Counter.count += 1;
    }
  }
}

class DecThread extends Thread {

  public void run() {
    for (int i = 0; i < 10000; i++) {
      Counter.count -= 1;
    }
  }
}
