package multithreads.atomic;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {

  AtomicLong atomicLong = new AtomicLong(0);

  public long getNextId() {
    return atomicLong.incrementAndGet();
  }
}
