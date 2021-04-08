public class IfJudgmentDemo4 {

  public static void main(String[] args) {
    //        在串联使用多个if时，要特别注意判断顺序。观察下面的代码：
    //        int n = 100;
    //        if (n >= 60) {
    //            System.out.println("及格了");
    //        } else if (n >= 90) {
    //            System.out.println("优秀");
    //        } else {
    //            System.out.println("挂科了");
    //        }

    //        执行发现，n = 100时，满足条件n >= 90，但输出的不是"优秀"，而是"及格了"，原因是if语句从上到下执行时，先判断n >= 60成功后，后续else不再执行，因此，if (n >= 90)没有机会执行了。
    /*
        * 正确的方式是按照判断范围从大到小依次判断：

            // 从大到小依次判断：
            if (n >= 90) {
                // ...
            } else if (n >= 60) {
                // ...
            } else {
                // ...
            }
            或者改写成从小到大依次判断：

            // 从小到大依次判断：
            if (n < 60) {
                // ...
            } else if (n < 90) {
                // ...
            } else {
                // ...
            }
        *
        * */

    //        还要特别注意边界条件。例如：
    int n = 90;
    if (n > 90) {
      System.out.println("优秀");
    } else if (n >= 60) {
      System.out.println("及格了");
    } else {
      System.out.println("挂科了");
    }

    //        浮点数在计算机中常常无法精确表示，并且计算可能出现误差，因此，判断浮点数相等用==判断不靠谱：
    double x = 1 - 9.0 / 10;
    if (x == 0.1) {
      System.out.println("x is 0.1");
    } else {
      System.out.println("x is NOT 0.1");
    }

    //        正确的方法是利用差值小于某个临界值来判断

    double x2 = 1 - 9.0 / 10;
    if (Math.abs(x2 - 0.1) < 0.00001) {
      System.out.println("x is 0.1");
    } else {
      System.out.println("x is NOT 0.1");
    }
  }
}
