public class ForLoopDemo1 {

  public static void main(String[] args) {
    //        除了while和do while循环，Java使用最广泛的是for循环。
    //
    //        for循环的功能非常强大，它使用计数器实现循环。for循环会先初始化计数器，然后，在每次循环前检测循环条件，在每次循环后更新计数器。计数器变量通常命名为i。
    //        我们把1到100求和用for循环改写一下：
    //        在for循环执行前，会先执行初始化语句int i=1，它定义了计数器变量i并赋初始值为1，
    //       然后，循环前先检查循环条件i<=100，循环后自动执行i++，
    //      因此，和while循环相比，for循环把更新计数器的代码统一放到了一起。
    //     在for循环的循环体内部，不需要去更新变量i。
    int sum = 0;
    for (int i = 1; i <= 100; i++) {
      sum = sum + i;
    }
    System.out.println(sum);
  }
}
