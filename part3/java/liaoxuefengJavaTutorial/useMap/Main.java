package useMap;

import java.util.HashMap;
import java.util.Map;

public class Main {

  public static void main(String[] args) {
    //        Map这种键值（key-value）映射表的数据结构，作用就是能高效通过key快速查找value（元素）。
    Student s = new Student("Xiao Ming", 99);

    Map<String, Student> map = new HashMap<>();
    map.put("Xiao Ming", s); // 将"Xiao Ming"和Student实例映射并关联
    Student target = map.get("Xiao Ming"); // 通过key查找并返回映射的Student实例
    System.out.println(target == s); // true，同一个实例
    System.out.println(target.score); // 99
    Student another = map.get("Bob"); // 通过另一个key查找
    System.out.println(another); // 未找到返回null
  }
}
