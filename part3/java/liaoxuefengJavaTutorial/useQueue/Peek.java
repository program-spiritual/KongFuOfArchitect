package useQueue;

import java.util.*;

/**
 * 通过add()/offer()方法将元素添加到队尾；
 * 通过remove()/poll()从队首获取元素并删除；
 * 通过element()/peek()从队首获取元素但不删除
 * 要避免把null添加到队列
 *
 * */
public class Peek {

  public static void main(String[] args) {
    Queue<String> q = new LinkedList<>();
    // 添加3个元素到队列:
    q.offer("apple");
    q.offer("pear");
    q.offer("banana");
    // 队首永远都是apple，因为peek()不会删除它:
    System.out.println(q.peek()); // apple
    System.out.println(q.peek()); // apple
    System.out.println(q.peek()); // apple
  }
}
