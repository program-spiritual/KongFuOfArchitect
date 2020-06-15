package multithreads.future;

/**
 *
 * 一个Future<V>接口表示一个未来可能会返回的结果，它定义的方法有：
 *
 * get()：获取结果（可能会等待）
 * get(long timeout, TimeUnit unit)：获取结果，但只等待指定的时间；
 * cancel(boolean mayInterruptIfRunning)：取消当前任务；
 * isDone()：判断任务是否已完成。
 *
 * */

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
// 定义任务:
        Callable<String> task = new TaskDemo();
// 提交任务并获得Future:
        Future<String> future = executor.submit(task);
// 从Future获取异步执行返回的结果:
        try {
            String result = future.get(); // 可能阻塞
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}


class TaskDemo implements Callable<String> {
    public String call() throws Exception {
        return longTimeCalculation();
    }

    private String longTimeCalculation() {
        return null;
    }
}


