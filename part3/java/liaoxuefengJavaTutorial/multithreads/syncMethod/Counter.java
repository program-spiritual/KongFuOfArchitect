package multithreads.syncMethod;

public class Counter {

  private int count = 0;

  public void add(int n) {
    synchronized (this) {
      count += n;
    }
  }

  public void dec(int n) {
    synchronized (this) {
      count -= n;
    }
  }

  public int get() {
    return count;
  }

  public void add() {}

  public void dec() {}
}
