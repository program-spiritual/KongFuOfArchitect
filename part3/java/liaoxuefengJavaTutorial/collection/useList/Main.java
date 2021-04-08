package collection.useList;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    //        使用List时，我们要关注List接口的规范。
    //       List接口允许我们添加重复的元素，即List内部的元素可以重复：
    List<String> list = new ArrayList<>();
    list.add("apple"); // size=1
    list.add("pear"); // size=2
    list.add("apple"); // 允许重复添加元素，size=3
    System.out.println(list.size());
    //        添加 null
    list.add(null); // size=2
    String nilVal = list.get(3); // null
    System.out.println(nilVal);
    //        快速创建 list  List.of()方法不接受null值，如果传入null，会抛出NullPointerException异常
    List<Integer> list2 = List.of(1, 2, 5);
    System.out.println(list2);
  }
}
