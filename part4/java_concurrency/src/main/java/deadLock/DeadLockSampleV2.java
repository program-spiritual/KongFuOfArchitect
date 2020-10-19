package deadLock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DeadLockSampleV2 extends Thread {
    private String first;
    private String second;

    public DeadLockSampleV2(String name, String first, String second) {
        super(name);
        this.first = first;
        this.second = second;
    }

    public void run() {

        synchronized (first) {
            System.out.println(this.getName() + this.getId() + " obtained: " + first);
            try {
                Thread.sleep(1000L);
                synchronized (second) {
                    System.out.println(this.getName() + " obtained: " + second);
                }
            } catch (InterruptedException e) {
                // Do nothing
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long pid = ProcessHandle.current().pid();
        System.out.println("pid:" + pid);
        ThreadMXBean mbean = ManagementFactory.getThreadMXBean();

        // 死锁检测
        Runnable dlCheck = new Runnable() {
            @Override
            public void run() {
                long[] threadIds = mbean.findDeadlockedThreads();
                if (threadIds != null) {
                    ThreadInfo[] threadInfos = mbean.getThreadInfo(threadIds);
                    System.out.println("Detected deadlock threads:");
                    for (ThreadInfo threadInfo : threadInfos) {
                        System.out.println(threadInfo.getThreadName());
                    }
                }
            }
        };

        // 稍等5秒，然后每10秒进行一次死锁扫描
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(dlCheck, 5L, 10L, TimeUnit.SECONDS);

        //  死锁样例代码
        String lockA = "lockA";
        String lockB = "lockB";
        DeadLockSampleV2 t1 = new DeadLockSampleV2("Thread1", lockA, lockB);
        DeadLockSampleV2 t2 = new DeadLockSampleV2("Thread2", lockB, lockA);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}

