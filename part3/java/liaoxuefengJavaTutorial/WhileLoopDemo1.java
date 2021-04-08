public class WhileLoopDemo1 {

  public static void main(String[] args) {
    //        while循环在每次循环开始前，首先判断条件是否成立。
    //       如果计算结果为true，就把循环体内的语句执行一遍，
    //      如果计算结果为false，那就直接跳到while循环的末尾，继续往下执行。
    //        我们用while循环来累加1到100，可以这么写：
    int sum = 0; // 累加的和，初始化为0
    int n = 1;
    while (n <= 100) { // 循环条件是n <= 100
      sum = sum + n; // 把n累加到sum中
      n++; // n自身加1
    }
    System.out.println(sum); // 5050
  }
}
