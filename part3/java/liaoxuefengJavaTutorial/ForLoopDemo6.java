public class ForLoopDemo6 {

  public static void main(String[] args) {
    //        无论是while循环还是for循环，有两个特别的语句可以使用，就是break语句和continue语句。
    //        在循环过程中，可以使用break语句跳出当前循环。我们来看一个例子：
    for (int i = 1; i <= 10; i++) {
      System.out.println("i = " + i);
      for (int j = 1; j <= 10; j++) {
        System.out.println("j = " + j);
        if (j >= i) {
          break;
        }
      }
      // break跳到这里
      System.out.println("breaked");
      //            上面的代码是两个for循环嵌套。因为break语句位于内层的for循环，因此，它会跳出内层for循环，但不会跳出外层for循环。
    }
  }
}
