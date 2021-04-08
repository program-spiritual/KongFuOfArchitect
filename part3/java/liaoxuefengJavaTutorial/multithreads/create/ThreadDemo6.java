package multithreads.create;

/**
 * 直接调用run()方法，相当于调用了一个普通的Java方法，当前线程并没有任何改变，也不会启动新线程。
 * 上述代码实际上是在main()方法内部又调用了run()方法，
 * 打印hello语句是在main线程中执行的，没有任何新线程被创建。
 *
 * 必须调用Thread实例的start()方法才能启动新线程，
 * 如果我们查看Thread类的源代码，会看到start()方法内部调用了一个private native void start0()方法，
 * native修饰符表示这个方法是由JVM虚拟机内部的C代码实现的，不是由Java代码实现的。
 *
 * */
public class ThreadDemo6 {

  public static void main(String[] args) {
    Thread t = new MyThread2();
    t.run();
  }
}

class MyThread2 extends Thread {

  public void run() {
    System.out.println("hello");
  }
}
