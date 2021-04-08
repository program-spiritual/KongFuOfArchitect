package useDeque;

import java.util.*;

public class Main {

  public static void main(String[] args) {
    //        如果把条件放松一下，允许两头都进，两头都出，这种队列叫双端队列（Double Ended Queue），学名Deque。
    //        既可以添加到队尾，也可以添加到队首；
    //        既可以从队首获取，又可以从队尾获取。
    Deque<String> deque = new LinkedList<>();
    deque.offerLast("A"); // A
    deque.offerLast("B"); // B -> A
    System.out.println(deque);
    deque.offerFirst("C"); // B -> A ->
    System.out.println(deque);
    System.out.println(deque.pollFirst()); // C, 剩下B -> A
    System.out.println(deque.pollLast()); // B
    System.out.println(deque.pollFirst()); // A
    System.out.println(deque.pollFirst()); // null
  }
}
