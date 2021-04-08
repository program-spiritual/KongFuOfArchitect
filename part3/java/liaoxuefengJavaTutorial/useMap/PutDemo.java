package useMap;

import java.util.HashMap;
import java.util.Map;

public class PutDemo {

  public static void main(String[] args) {
    Map<String, Integer> map = new HashMap<>();
    map.put("apple", 123);
    map.put("pear", 456);
    System.out.println(map.get("apple")); // 123
    map.put("apple", 789); // 再次放入apple作为key，但value变为789
    System.out.println(map.get("apple")); // 789
    //        Map中不存在重复的key，因为放入相同的key，只会把原有的key-value对应的value给替换掉。
  }
}
