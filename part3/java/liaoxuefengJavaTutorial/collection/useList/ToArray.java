package collection.useList;

import java.util.List;

public class ToArray {

  public static void main(String[] args) {
    //        给toArray(T[])传入一个类型相同的Array，List内部自动把元素复制到传入的Array中

    List<Integer> list = List.of(12, 34, 56);
    Integer[] array = list.toArray(new Integer[3]);
    for (Integer n : array) {
      System.out.println(n);
    }
    //        这个toArray(T[])方法的泛型参数<T>并不是List接口定义的泛型参数<E>，
    //       所以，我们实际上可以传入其他类型的数组，例如我们传入Number类型的数组，返回的仍然是Number类型：
  }
}
