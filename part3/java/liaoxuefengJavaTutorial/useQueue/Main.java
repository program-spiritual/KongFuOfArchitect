package useQueue;

import java.util.*;

public class Main {

  /***
     * int size()：获取队列长度；
     * boolean add(E)/boolean offer(E)：添加元素到队尾；
     * E remove()/E poll()：获取队首元素并从队列中删除；
     * E element()/E peek()：获取队首元素但并不从队列中删除。
     *
                        throw Exception	    返回false或null
     添加元素到队尾	    add(E e)    	    boolean offer(E e)
     取队首元素并删除	    E remove()  	    E poll()
     取队首元素但不删除	E element()	        E peek()
     * */
  public static void main(String[] args) {
    // 接下来我们以poll()和peek()为例来说说“获取并删除”与“获取但不删除”的区别。
    //对于Queue来说，每次调用poll()，都会获取队首元素，并且获取到的元素已经从队列中被删除了
    Queue<String> q = new LinkedList<>();
    // 添加3个元素到队列:
    q.offer("apple");
    q.offer("pear");
    q.offer("banana");
    // 从队列取出元素:
    System.out.println(q.poll()); // apple
    System.out.println(q.poll()); // pear
    System.out.println(q.poll()); // banana
    System.out.println(q.poll()); // null,因为队列是空的
  }
}
