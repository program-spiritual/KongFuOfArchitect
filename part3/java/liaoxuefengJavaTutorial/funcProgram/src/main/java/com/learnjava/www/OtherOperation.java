package com.learnjava.www;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream提供的常用操作有：
 * <p>
 * 转换操作：map()，filter()，sorted()，distinct()；
 * <p>
 * 合并操作：concat()，flatMap()；
 * <p>
 * 并行处理：parallel()；
 * <p>
 * 聚合操作：reduce()，collect()，count()，max()，min()，sum()，average()；
 * <p>
 * 其他操作：allMatch(), anyMatch(), forEach()。
 *
 *
 * 除了reduce()和collect()外，Stream还有一些常用的聚合方法：
 *
 * count()：用于返回元素个数；
 * max(Comparator<? super T> cp)：找出最大元素；
 * min(Comparator<? super T> cp)：找出最小元素。
 * 针对IntStream、LongStream和DoubleStream，还额外提供了以下聚合方法：
 *
 * sum()：对所有元素求和；
 * average()：对所有元素求平均数。
 * 还有一些方法，用来测试Stream的元素是否满足以下条件：
 *
 * boolean allMatch(Predicate<? super T>)：测试是否所有元素均满足测试条件；
 * boolean anyMatch(Predicate<? super T>)：测试是否至少有一个元素满足测试条件。
 */
public class OtherOperation {

  public static void main(String[] args) {
    sort();
    userDefinedSort();
  }

  //    默认排序
  static void sort() {
    List<String> list = List
      .of("Orange", "apple", "Banana")
      .stream()
      .sorted()
      .collect(Collectors.toList());
    System.out.println(list);
  }

  //  自定义排序
  static void userDefinedSort() {
    List<String> list = List
      .of("Orange", "apple", "Banana")
      .stream()
      .sorted(String::compareToIgnoreCase)
      .collect(Collectors.toList());
    System.out.println(list);
  }

  //  去重
  static void distinct() {
    List
      .of("A", "B", "A", "C", "B", "D")
      .stream()
      .distinct()
      .collect(Collectors.toList()); // [A, B, C, D]
  }

  //  截取
  static void skip() {
    List
      .of("A", "B", "C", "D", "E", "F")
      .stream()
      .skip(2) // 跳过A, B
      .limit(3) // 截取C, D, E
      .collect(Collectors.toList()); // [C, D, E]
  }

  //    合并
  static void concat() {
    Stream<String> s1 = List.of("A", "B", "C").stream();
    Stream<String> s2 = List.of("D", "E").stream();
    // 合并:
    Stream<String> s = Stream.concat(s1, s2);
    System.out.println(s.collect(Collectors.toList())); // [A, B, C, D, E]
  }

  // flatMap
  static void flatMap() {
    Stream<List<Integer>> s = Stream.of(
      Arrays.asList(1, 2, 3),
      Arrays.asList(4, 5, 6),
      Arrays.asList(7, 8, 9)
    );
  }

  //    parallel
  static void parallel() {
    Stream<String> s = List.of("A", "B", "C").stream();
    String[] result = s
      .parallel() // 变成一个可以并行处理的Stream
      .sorted() // 可以进行并行排序
      .toArray(String[]::new);
  }

  static void forEach() {
    Stream<String> s = List.of("A", "B", "C").stream();
    s.forEach(
      str -> {
        System.out.println("Hello, " + str);
      }
    );
  }
}
