package com.learnjava.www;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Output2List {

  public static void main(String[] args) {
    toList();
    toArray();
    toMap();
    groupBy();
  }

  static void toList() {
    Stream<String> stream = Stream.of(
      "Apple",
      "",
      null,
      "Pear",
      "  ",
      "Orange"
    );
    List<String> list = stream
      .filter(s -> s != null && !s.isBlank())
      .collect(Collectors.toList());
    System.out.println(list);
  }

  static void toArray() {
    List<String> list = List.of("Apple", "Banana", "Orange");
    String[] array = list.stream().toArray(String[]::new);
    System.out.println(array);
  }

  //        如果我们要把Stream的元素收集到Map中，就稍微麻烦一点。
  //       因为对于每个元素，添加到Map时需要key和value，
  //      因此，我们要指定两个映射函数，分别把元素映射为key和value：
  static void toMap() {
    Stream<String> stream = Stream.of("APPL:Apple", "MSFT:Microsoft");
    Map<String, String> map = stream.collect(
      Collectors.toMap(
        // 把元素s映射为key:
        s -> s.substring(0, s.indexOf(':')),
        // 把元素s映射为value:
        s -> s.substring(s.indexOf(':') + 1)
      )
    );
    System.out.println(map);
  }

  //    分组输出使用Collectors.groupingBy()，
  //   它需要提供两个函数：一个是分组的key，
  //  这里使用s -> s.substring(0, 1)，
  // 表示只要首字母相同的String分到一组，第二个是分组的value，
  //这里直接使用Collectors.toList()，表示输出为List，上述代码运行结果如下：
  static void groupBy() {
    List<String> list = List.of(
      "Apple",
      "Banana",
      "Blackberry",
      "Coconut",
      "Avocado",
      "Cherry",
      "Apricots"
    );
    Map<String, List<String>> groups = list
      .stream()
      .collect(
        Collectors.groupingBy(s -> s.substring(0, 1), Collectors.toList())
      );
    System.out.println(groups);
  }
}
