public class ForEachArrayDemo1 {

  public static void main(String[] args) {
    //我们在Java程序基础里介绍了数组这种数据类型。有了数组，我们还需要来操作它。而数组最常见的一个操作就是遍历。
    //
    //通过for循环就可以遍历数组。因为数组的每个元素都可以通过索引来访问，因此，使用标准的for循环可以完成一个数组的遍历：
    int[] ns = { 1, 4, 9, 16, 25 };
    for (int i = 0; i < ns.length; i++) {
      int n = ns[i];
      System.out.println(n);
    }
    //    为了实现for循环遍历，初始条件为i=0，因为索引总是从0开始，
    //   继续循环的条件为i<ns.length，因为当i=ns.length时
    //  ，i已经超出了索引范围（索引范围是0 ~ ns.length-1），每次循环后，i++。

    //    第二种方式是使用for each循环，直接迭代数组的每个元素：
    for (int n : ns) {
      System.out.println(n);
    }
  }
}
