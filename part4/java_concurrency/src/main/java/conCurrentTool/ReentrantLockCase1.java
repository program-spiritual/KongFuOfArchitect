package conCurrentTool;

/**
 * @javaVersion 14
 * public final void acquire(int arg) {
 *         if (!tryAcquire(arg))
 *             acquire(null, arg, false, false, false, 0L);
 *     }
 */

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class ReentrantLockCase1 {
    private final Sync sync;

    public ReentrantLockCase1(Sync sync) {
        this.sync = sync;
    }

    public void lock() {
        sync.acquire(1);
    }
    public void unlock() {
        sync.release(1);
    }


    abstract static class Sync extends AbstractQueuedSynchronizer { }
}
