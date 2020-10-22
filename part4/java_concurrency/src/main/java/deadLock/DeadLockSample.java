package deadLock;

public class DeadLockSample extends Thread {
    private final String first;
    private final String second;
    public DeadLockSample(String name, String first, String second) {
        super(name);
        this.first = first;
        this.second = second;
    }

    public  void run() {
        synchronized (first) {
            System.out.println(this.getName()+this.getId() + " obtained: " + first);
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
        System.out.println("pid:"+pid);
        String lockA = "lockA";
        String lockB = "lockB";
        DeadLockSample t1 = new DeadLockSample("Thread1", lockA, lockB);
        DeadLockSample t2 = new DeadLockSample("Thread2", lockB, lockA);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}

/**
 * jstack 的调试日志：
 * Found one Java-level deadlock:
 * =============================
 * "Thread1":
 *   waiting to lock monitor 0x00000296825a0c00 (object 0x0000000091f86cc0, a java.lang.String),
 *   which is held by "Thread2"
 *
 * "Thread2":
 *   waiting to lock monitor 0x00000296a2262a80 (object 0x0000000091f86c90, a java.lang.String),
 *   which is held by "Thread1"
 *
 * Java stack information for the threads listed above:
 * ===================================================
 * "Thread1":
 *         at deadLock.DeadLockSample.run(deadLock.DeadLockSample.java:17)
 *         - waiting to lock <0x0000000091f86cc0> (a java.lang.String)
 *         - locked <0x0000000091f86c90> (a java.lang.String)
 * "Thread2":
 *         at deadLock.DeadLockSample.run(deadLock.DeadLockSample.java:17)
 *         - waiting to lock <0x0000000091f86c90> (a java.lang.String)
 *         - locked <0x0000000091f86cc0> (a java.lang.String)
 *
 * Found 1 deadlock.
 * */