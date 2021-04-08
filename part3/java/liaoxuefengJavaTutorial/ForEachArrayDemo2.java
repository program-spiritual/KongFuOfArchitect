import java.util.Arrays;

public class ForEachArrayDemo2 {

  public static void main(String[] args) {
    //        直接打印数组变量，得到的是数组在JVM中的引用地址：
    int[] ns = { 1, 1, 2, 3, 5, 8 };
    System.out.println(ns); // 类似 [I@7852e922
    //        这并没有什么意义，因为我们希望打印的数组的元素内容。因此，使用for each循环来打印它：
    for (int n : ns) {
      System.out.print(n + ", ");
    }
    //        使用for each循环打印也很麻烦。幸好Java标准库提供了Arrays.toString()，可以快速打印数组内容：
    System.out.println(Arrays.toString(ns));
  }
}
