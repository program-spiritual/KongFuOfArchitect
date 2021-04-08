package datetime.calendar;

import java.util.Calendar;

public class Main {

  public static void main(String[] args) {
    //        Calendar可以用于获取并设置年、月、日、时、分、秒，
    //       它和Date比，主要多了一个可以做简单的日期和时间运算的功能。
    // 获取当前时间:
    Calendar c = Calendar.getInstance();
    int y = c.get(Calendar.YEAR);
    int m = 1 + c.get(Calendar.MONTH);
    int d = c.get(Calendar.DAY_OF_MONTH);
    int w = c.get(Calendar.DAY_OF_WEEK);
    int hh = c.get(Calendar.HOUR_OF_DAY);
    int mm = c.get(Calendar.MINUTE);
    int ss = c.get(Calendar.SECOND);
    int ms = c.get(Calendar.MILLISECOND);
    System.out.println(
      y +
      "-" +
      m +
      "-" +
      d +
      " " +
      w +
      " " +
      hh +
      ":" +
      mm +
      ":" +
      ss +
      "." +
      ms
    );
  }
}
