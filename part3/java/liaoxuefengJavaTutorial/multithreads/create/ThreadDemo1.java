package multithreads.create;

public class ThreadDemo1 {

  public static void main(String[] args) {
    Thread t = new MyThread();
    t.start();
  }
}

class MyThread extends Thread {

  @Override
  public void run() {
    super.run();
    System.out.println("start new thread!");
  }
}
