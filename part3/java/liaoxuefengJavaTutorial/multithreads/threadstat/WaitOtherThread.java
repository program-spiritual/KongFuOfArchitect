package multithreads.threadstat;
/*********************************************************************************************
 * main线程在启动t线程后，可以通过t.join()等待t线程结束后再继续运行
 *
 *
 * 当main线程对线程对象t调用join()方法时，主线程将等待变量t表示的线程运行结束，
 * 即join就是指等待该线程结束，然后才继续往下执行自身线程。
 * 所以，上述代码打印顺序可以肯定是main线程先打印start，
 * t线程再打印hello，main线程最后再打印end。
 *
 * 如果t线程已经结束，对实例t调用join()会立刻返回。
 * 此外，join(long)的重载方法也可以指定一个等待时间，超过等待时间后就不再继续等待。
 *
 *
 *********************************************************************************************/
public class WaitOtherThread {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("hello");
        });
        System.out.println("start");
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
