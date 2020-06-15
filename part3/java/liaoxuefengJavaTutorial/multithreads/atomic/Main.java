package multithreads.atomic;
/*******************************************************************************************
 *
 * 我们以AtomicInteger为例，它提供的主要操作有：
 *
 * 增加值并返回新值：int addAndGet(int delta)
 * 加1后返回新值：int incrementAndGet()
 * 获取当前值：int get()
 * 用CAS方式设置：int compareAndSet(int expect, int update)
 *
 * Atomic类是通过无锁（lock-free）的方式实现的线程安全（thread-safe）访问。它的主要原理是利用了CAS：Compare and Set。
 *
 ******************************************************************************************/
public class Main {
    public static void main(String[] args) {
//利用AtomicLong可以编写一个多线程安全的全局唯一ID生成器：

    }
}
