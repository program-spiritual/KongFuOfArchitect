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