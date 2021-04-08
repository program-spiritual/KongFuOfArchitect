package multithreads.deadlock;

/**
 * JVM允许同一个线程重复获取同一个锁，这种能被同一个线程反复获取的锁，就叫做可重入锁。
 由于Java的线程锁是可重入锁，所以，获取锁的时候，不但要判断是否是第一次获取，还要记录这是第几次获取。
 每获取一次锁，记录+1，每退出synchronized块，记录-1，减到0的时候，才会真正释放锁

 应该如何避免死锁呢？答案是：线程获取锁的顺序要一致。即严格按照先获取lockA，再获取lockB的顺序，改写dec()方法如下
 * */

public class Main {

  public static void main(String[] args) {}
}
