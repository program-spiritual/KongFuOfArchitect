package useSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Set用于存储不重复的元素集合，它主要提供以下几个方法：
 *
 * 将元素添加进Set<E>：boolean add(E e)
 * 将元素从Set<E>删除：boolean remove(Object e)
 * 判断是否包含元素：boolean contains(Object e)
 * */
public class Main {

  public static void main(String[] args) {
    //        如果我们只需要存储不重复的key，并不需要存储映射的value，那么就可以使用Set。
    Set<String> set = new HashSet<>();
    System.out.println(set.add("abc")); // true
    System.out.println(set.add("xyz")); // true
    System.out.println(set.add("xyz")); // false，添加失败，因为元素已存在
    System.out.println(set.contains("xyz")); // true，元素存在
    System.out.println(set.contains("XYZ")); // false，元素不存在
    System.out.println(set.remove("hello")); // false，删除失败，因为元素不存在
    System.out.println(set.size()); // 2，一共两个元素
  }
}
