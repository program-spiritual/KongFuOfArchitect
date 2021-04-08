package usePriorityQueue;

import java.util.*;

public class Main {

  public static void main(String[] args) {
    //        要使用PriorityQueue，我们就必须给每个元素定义“优先级”。
    Queue<String> q = new PriorityQueue<>();
    // 添加3个元素到队列:
    q.offer("apple");
    q.offer("pear");
    q.offer("banana");
    System.out.println(q.poll()); // apple
    System.out.println(q.poll()); // banana
    System.out.println(q.poll()); // pear
    System.out.println(q.poll()); // null,因为队列为空
  }
}
