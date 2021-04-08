package com.learnjava.www;

import java.util.Arrays;

public class MethodRef {

  //    除了Lambda表达式，我们还可以直接传入方法引用。例如：
  public static void main(String[] args) {
    String[] array = new String[] { "Apple", "Orange", "Banana", "Lemon" };
    //        因为Comparator<String>接口定义的方法是int compare(String, String)，
    //       和静态方法int cmp(String, String)相比，除了方法名外，方法参数一致，返回类型相同，
    //      因此，我们说两者的方法签名一致，可以直接把方法名作为Lambda表达式传入：
    Arrays.sort(array, MethodRef::cmp);
    System.out.println(String.join(", ", array));
  }

  static int cmp(String s1, String s2) {
    return s1.compareTo(s2);
  }
}
