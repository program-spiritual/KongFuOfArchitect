public class MultidimensionalArraysDemo5 {

  public static void main(String[] args) {
    // 用二维数组表示的学生成绩:
    int[][] scores = {
      { 82, 90, 91 },
      { 68, 72, 64 },
      { 95, 91, 89 },
      { 67, 52, 60 },
      { 79, 81, 85 },
    };
    double average = 0;
    double total = 0.00;
    int count = 0;
    for (int[] array : scores) {
      for (int item : array) {
        total += item;
        count++;
      }
    }
    average = total / count;
    System.out.println(average);
    if (Math.abs(average - 77.733333) < 0.000001) {
      System.out.println("测试成功");
    } else {
      System.out.println("测试失败");
    }
  }
}
