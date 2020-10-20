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
  
  