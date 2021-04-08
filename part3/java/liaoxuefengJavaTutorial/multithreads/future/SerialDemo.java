package multithreads.future;

import java.util.concurrent.CompletableFuture;

public class SerialDemo {

  public static void main(String[] args) {
    // 第一个任务:
    CompletableFuture<String> cfQuery = CompletableFuture.supplyAsync(
      () -> {
        return queryCode("中国石油");
      }
    );
    // cfQuery成功后继续执行下一个任务:
    CompletableFuture<Double> cfFetch = cfQuery.thenApplyAsync(
      code -> {
        return fetchPrice(code);
      }
    );
    // cfFetch成功后打印结果:
    cfFetch.thenAccept(
      result -> {
        System.out.println("price: " + result);
      }
    );
    // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  static String queryCode(String name) {
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {}
    return "601857";
  }

  static Double fetchPrice(String code) {
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {}
    return 5 + Math.random() * 20;
  }
}
