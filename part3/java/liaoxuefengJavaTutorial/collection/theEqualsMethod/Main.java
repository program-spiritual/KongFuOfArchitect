package collection.theEqualsMethod;

import java.util.List;

public class Main {

  public static void main(String[] args) {
    //List还提供了boolean contains(Object o)方法来判断List是否包含某个指定元素。
    //此外，int indexOf(Object o)方法可以返回某个元素的索引，如果元素不存在，就返回-1。
    List<String> list = List.of("A", "B", "C");
    System.out.println(list.contains("C")); // true
    System.out.println(list.contains("X")); // false
    System.out.println(list.indexOf("C")); // 2
    System.out.println(list.indexOf("X")); // -1
    //往List中添加的"C"和调用contains("C")传入的"C"是不是同一个实例？
    System.out.println(list.contains(new String("C"))); // true or false?
    System.out.println(list.indexOf(new String("C"))); // 2 or -1?
    //        因为List内部并不是通过==判断两个元素是否相等，而是使用equals()方法判断两个元素是否相等，
    //我们之所以能正常放入String、Integer这些对象，是因为Java标准库定义的这些类已经正确实现了equals()方法。
  }
}
