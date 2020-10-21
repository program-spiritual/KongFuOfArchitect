## 目录

### 死锁

- [DeadLockSample](src/main/java/deadLock/DeadLockSample.java)
- [DeadLockSampleV2](src/main/java/deadLock/DeadLockSampleV2.java)

如何预防死锁？

- 尽量避免使用多个锁，并且只有需要时才持有锁
- 如果必须使用多个锁，尽量设计好锁的获取顺序
  - 辅助手法
    - 使用图的方式表达
    - 对象之间组合、调用的关系对比和组合，考虑可能调用时序。
    - 按照可能时序合并，发现可能死锁的场景。
- 使用带超时的方法
```java

if (lock.tryLock() || lock.tryLock(timeout, unit)) {
    // ...
   }

```

- 通过静态代码分析

## 并发工具

### Semaphore
[UsualSemaphoreSample](src/main/java/conCurrentTool/UsualSemaphoreSample.java)
### AbnormalSemaphore
[AbnormalSemaphoreSample](src/main/java/conCurrentTool/AbnormalSemaphoreSample.java)
### SemaphoreWorker
[SemaphoreWorker](src/main/java/conCurrentTool/SemaphoreWorker.java)
### LatchSample
[LatchSample](src/main/java/conCurrentTool/LatchSample.java)

## 队列

[LinkedBlockingQueue](./src/main/java/queue/LinkedBlockingQueue.java)

### 队列使用场景与典型用例

[生产者-消费者](src/main/java/queue/ConsumerProducer.java)

## `Java` 并发类库提供的线程池

- `newCachedThreadPool`
  - 处理大量短时间工作任务的线程池
- `newFixedThreadPool`
  - 其背后使用的是无界的工作队列，任何时候最多有 `nThreads` 个工作线程是活动的
- `newSingleThreadExecutor`
  - 它的特点在于工作线程数目被限制为 1
- `newSingleThreadScheduledExecutor`
  - 进行定时或周期性的工作调度，区别在于单一工作线程还是多个工作线程
- `newWorkStealingPool`
  - 并行地处理任务，不保证处理顺序。
  
## 线程池的几个基本组成部分

- `corePoolSize`，所谓的核心线程数，可以大致理解为长期驻留的线程数目（除非设置了 allowCoreThreadTimeOut）
- `maximumPoolSize`，顾名思义，就是线程不够时能够创建的最大线程数
- `keepAliveTime` 和 `TimeUnit`，这两个参数指定了额外的线程能够闲置多久，显然有些线程池不需要它。
- `workQueue`，工作队列，必须是 `BlockingQueue`

构造函数的配置：

```java

public ThreadPoolExecutor(int corePoolSize,
                        int maximumPoolSize,
                        long keepAliveTime,
                        TimeUnit unit,
                        BlockingQueue<Runnable> workQueue,
                        ThreadFactory threadFactory,
                        RejectedExecutionHandler handler)

```

状态如何表征：

```java

private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
// 真正决定了工作线程数的理论上限 
private static final int COUNT_BITS = Integer.SIZE - 3;
private static final int COUNT_MASK = (1 << COUNT_BITS) - 1;
// 线程池状态，存储在数字的高位
private static final int RUNNING = -1 << COUNT_BITS;
…
// Packing and unpacking ctl
private static int runStateOf(int c)  { return c & ~COUNT_MASK; }
private static int workerCountOf(int c)  { return c & COUNT_MASK; }
private static int ctlOf(int rs, int wc) { return rs | wc; }
```

完整代码请见 `ExecuteMethod.java` ,仅供参考

## 实践

- 避免任务堆积
  - 排查工具 ： `jmap`
- 避免过度扩展线程
  - 在处理大量短时任务时，使用缓存的线程池
- 线程泄漏
  - 任务逻辑有问题，导致工作线程迟迟不能被释放。
- 避免死锁等同步问题
- 尽量避免在使用线程池时操作 `ThreadLocal`  

## 线程池大小选择

- 通常建议按照 `CPU` 核的数目 `N` 或者 `N+1`。
- 较多等待的任务
  - `Brain Goetz` 推荐的计算方法：
    - 根据采样或者概要分析等方式进行计算，然后在实际中验证和调整。
```text
线程数 = CPU核数 × 目标CPU利用率 ×（1 + 平均等待时间/平均工作时间）
``` 
- 实际还可能受各种系统资源限制影响
- 很多时候架构上的改变更能解决问题 

## `AtomicInteger` 底层实现原理

### CAS
表征的是一些列操作的集合，获取当前数值，进行一些运算，利用 `CAS` 指令试图进行更新
否则，可能出现不同的选择，要么进行重试，要么就返回一个成功或者失败的结果。
### 场景
如何在数据库抽象层面实现，只有一个线程能够排他性地修改一个索引分区？

1. 可以考虑为索引分区对象添加一个逻辑上的锁：

```java

public class AtomicBTreePartition {
private volatile long lock;
public void acquireLock(){}
public void releaseeLock(){}
}
```
2. `JAVA` 提供的公共 `API` 

- AtomicLongFieldUpdater

```java

private static final AtomicLongFieldUpdater<AtomicBTreePartition> lockFieldUpdater =
        AtomicLongFieldUpdater.newUpdater(AtomicBTreePartition.class, "lock");

private void acquireLock(){
    long t = Thread.currentThread().getId();
    while (!lockFieldUpdater.compareAndSet(this, 0L, t)){
        // 等待一会儿，数据库操作可能比较慢
         …
    }
}
```

- Variable Handle API

```java

private static final VarHandle HANDLE = MethodHandles.lookup().findStaticVarHandle
        (AtomicBTreePartition.class, "lock");

private void acquireLock(){
    long t = Thread.currentThread().getId();
    while (!HANDLE.compareAndSet(this, 0L, t)){
        // 等待一会儿，数据库操作可能比较慢
        …
    }
}
```

## 理解 `AQS` 的原理与应用

- 原理
一种同步结构往往是可以利用其他的结构实现的
  - 可以使用 Semaphore 实现互斥锁
  - 对某种同步结构的倾向，会导致复杂、晦涩的实现逻辑
  - `Doug Lea` 将基础的同步相关操作抽象在 `AbstractQueuedSynchronizer` 中

- `AQS` 内部数据和方法  
  - 一个 `volatile` 的整数成员表征状态
  - `FIFO` 等待线程队列
  - 基于 `CAS` 的基础操作方法
  - 两个基本类型的方法
    - `acquire` 操作，获取资源的独占权
    - `release` 操作，释放对某个资源的独占
  
- 示例
  - `ReentrantLock` 
```java
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

```
`ReentrantLock` 中的 `tryAcquire` 实现：
- `NonfairSync` 和 `FairSync`

 `AQS` 内部 `tryAcquire` 仅仅是个接近未实现的方法（直接抛异常）
 
 ```java
 protected boolean tryAcquire(int arg) {
        throw new UnsupportedOperationException();
    }
```

公平性在 `ReentrantLock` 构建时:

```java

public ReentrantLock() {
        sync = new NonfairSync(); // 默认是非公平的
    }
    public ReentrantLock(boolean fair) {
        sync = fair ? new FairSync() : new NonfairSync();
    }

```

里体现了非公平的语义:

```java

final boolean nonfairTryAcquire(int acquires) {
    final Thread current = Thread.currentThread();
    int c = getState();// 获取当前AQS内部状态量
    if (c == 0) { // 0表示无人占有，则直接用CAS修改状态位，
      if (compareAndSetState(0, acquires)) {// 不检查排队情况，直接争抢
          setExclusiveOwnerThread(current);  //并设置当前线程独占锁
          return true;
      }
    } else if (current == getExclusiveOwnerThread()) { //即使状态不是0，也可能当前线程是锁持有者，因为这是再入锁
      int nextc = c + acquires;
      if (nextc < 0) // overflow
          throw new Error("Maximum lock count exceeded");
      setState(nextc);
      return true;
  }
  return false;
}   
```

当前线程会被包装成为一个排他模式的节点（`EXCLUSIVE`），通过 `addWaiter` 方法添加到队列中。

```java

final boolean acquireQueued(final Node node, int arg) {
      boolean interrupted = false;
      try {
      for (;;) {// 循环
          final Node p = node.predecessor();// 获取前一个节点
          if (p == head && tryAcquire(arg)) { // 如果前一个节点是头结点，表示当前节点合适去tryAcquire
              setHead(node); // acquire成功，则设置新的头节点
              p.next = null; // 将前面节点对当前节点的引用清空
              return interrupted;
          }
          if (shouldParkAfterFailedAcquire(p, node)) // 检查是否失败后需要park
              interrupted |= parkAndCheckInterrupt();
      }
       } catch (Throwable t) {
      cancelAcquire(node);// 出现异常，取消
      if (interrupted)
              selfInterrupt();
      throw t;
      }
}
```