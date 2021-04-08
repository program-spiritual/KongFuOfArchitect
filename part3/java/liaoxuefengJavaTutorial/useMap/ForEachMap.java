package useMap;

import java.util.HashMap;
import java.util.Map;

public class ForEachMap {

  public static void main(String[] args) {
    //        ，要遍历key可以使用for each循环遍历Map实例的keySet()方法返回的Set集合，它包含不重复的key的集合
    //        Map和List不同的是，Map存储的是key-value的映射关系，并且，它不保证顺序。

    Map<String, Integer> map = new HashMap<>();
    map.put("apple", 123);
    map.put("pear", 456);
    map.put("banana", 789);
    for (String key : map.keySet()) {
      Integer value = map.get(key);
      System.out.println(key + " = " + value);
    }
    //        同时遍历key和value可以使用for each循环遍历Map对象的entrySet()集合，它包含每一个key-value映射：
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      String key = entry.getKey();
      Integer value = entry.getValue();
      System.out.println(key + " = " + value);
    }
  }
}
