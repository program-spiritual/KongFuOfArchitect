package multithreads.daemonThreads;

/**
 * 在守护线程中，编写代码要注意：守护线程不能持有任何需要关闭的资源，
 * 例如打开文件等，因为虚拟机退出时，守护线程没有任何机会来关闭文件，这会导致数据丢失。
 *
 * */
public class CreateDaemonTHread {

  public static void main(String[] args) {
    Thread t = new MyThread();
    t.setDaemon(true);
    t.start();
  }
}

class MyThread extends Thread {

  public void run() {
    int n = 0;
    while (!isInterrupted()) {
      n++;
      System.out.println(n + " hello!");
    }
  }
}
