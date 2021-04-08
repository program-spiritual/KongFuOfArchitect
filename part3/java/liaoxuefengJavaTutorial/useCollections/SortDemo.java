package useCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Collections可以对List进行排序。因为排序会直接修改List元素的位置，因此必须传入可变List：
public class SortDemo {

  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("apple");
    list.add("pear");
    list.add("orange");
    // 排序前:
    System.out.println(list);
    Collections.sort(list);
    // 排序后:
    System.out.println(list);
  }
}
