package com.learnjava.www.structPatterns.flyweight;

import java.util.HashMap;
import java.util.Map;

public class Student {

  //    持有缓存
  private static final Map<String, Student> cache = new HashMap<>();

  //   静态工厂方法
  public static Student create(int id, String name) {
    String key = id + "\n" + name;
    Student student = cache.get(key);
    if (student == null) {
      // 未找到,创建新对象:
      System.out.println(String.format("create new Student(%s, %s)", id, name));
      student = new Student(id, name);
      // 放入缓存:
      cache.put(key, student);
    } else {
      // 缓存中存在:
      System.out.println(
        String.format("return cached Student(%s, %s)", student.id, student.name)
      );
    }

    return student;
  }

  private final int id;
  private final String name;

  public Student(int id, String name) {
    this.id = id;
    this.name = name;
  }
}
