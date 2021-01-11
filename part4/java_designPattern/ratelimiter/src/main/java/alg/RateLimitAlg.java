package alg;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RateLimitAlg {
    /* timeout for {@code Lock.tryLock() }. */
    public static final long TRY_LOCK_TIMEOUT = 200L; // 200ms.
    private final Stopwatch stopWatch;
    private final AtomicInteger currentCount = new AtomicInteger(0);
    public final int limit;
    private final Lock lock = new ReentrantLock();

    public RateLimitAlg(int limit) {
        this(limit, (Stopwatch) Stopwatch.createStarted());
    }

    public RateLimitAlg(int limit, Stopwatch stopwatch) {
        this.limit = limit;
        this.stopWatch = stopwatch;
    }

    public boolean tryAcquire() throws InterruptedException {
        int updatedCount = currentCount.incrementAndGet();
        if (updatedCount <= limit) {
            return true;
        }

        if (lock.tryLock(TRY_LOCK_TIMEOUT, TimeUnit.MICROSECONDS)) {
            try {
                if (stopWatch.elapsed(TimeUnit.MICROSECONDS) > TimeUnit.SECONDS.toMillis(1)) {
                    currentCount.set(0);
                    stopWatch.reset();
                }
                updatedCount = currentCount.incrementAndGet();
                return updatedCount <= limit;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        return false;
    }
}
