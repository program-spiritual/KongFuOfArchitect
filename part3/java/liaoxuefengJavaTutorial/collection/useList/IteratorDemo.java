package collection.useList;

import java.util.Iterator;
import java.util.List;

public class IteratorDemo {

  //    Iterator对象有两个方法：boolean hasNext()判断是否有下一个元素，E next()返回下一个元素。因此，使用Iterator遍历List代码如下：
  public static void main(String[] args) {
    List<String> list = List.of("apple", "pear", "banana");
    for (Iterator<String> it = list.iterator(); it.hasNext();) {
      String s = it.next();
      System.out.println(s);
    }
  }
}
