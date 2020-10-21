package conCurrentTool;

import java.util.ArrayDeque;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class ExcuteMethod {
    private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
    // 真正决定了工作线程数的理论上限
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int COUNT_MASK = (1 << COUNT_BITS) - 1;
    // 线程池状态，存储在数字的高位
    private static final int RUNNING = -1 << COUNT_BITS;
    private int corePoolSize;

    // Packing and unpacking ctl
    private static int runStateOf(int c)  { return c & ~COUNT_MASK; }
    private static int workerCountOf(int c)  { return c & COUNT_MASK; }
    private static int ctlOf(int rs, int wc) { return rs | wc; }
    BlockingDeque<Runnable> workQueue = null;


    public void execute(Runnable command) {
        int c = ctl.get();
// 检查工作线程数目，低于corePoolSize则添加Worker
        if (workerCountOf(c) < corePoolSize) {
            if (addWorker(command, true))
                return;
            c = ctl.get();
        }
// isRunning就是检查线程池是否被shutdown
// 工作队列可能是有界的，offer是比较友好的入队方式
        if (isRunning(c) && workQueue.offer(command)) {
            int recheck = ctl.get();
// 再次进行防御性检查
            if (! isRunning(recheck) && remove(command))
                reject(command);
            else if (workerCountOf(recheck) == 0)
                addWorker(null, false);
        }
// 尝试添加一个worker，如果失败意味着已经饱和或者被shutdown了
        else if (!addWorker(command, false))
            reject(command);
    }

    private void reject(Runnable command) {

    }

    private boolean remove(Runnable command) {
        return false;
    }

    private boolean addWorker(Runnable command, boolean b) {
        return false;
    }

    private boolean isRunning(int c) {
        return false;
    }

    public static void main(String[] args) {

    }
}
