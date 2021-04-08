package datetime.localdatetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main {

  public static void main(String[] args) {
    //        LocalDate d = LocalDate.now(); // 当前日期
    //        LocalTime t = LocalTime.now(); // 当前时间
    LocalDateTime dt = LocalDateTime.now(); // 当前日期和时间
    LocalDate d = dt.toLocalDate(); // 转换到当前日期
    LocalTime t = dt.toLocalTime(); // 转换到当前时间
    System.out.println(d); // 严格按照ISO 8601格式打印
    System.out.println(t); // 严格按照ISO 8601格式打印
    System.out.println(dt); // 严格按照ISO 8601格式打印
    // 指定日期和时间:
    LocalDate d2 = LocalDate.of(2019, 11, 30); // 2019-11-30, 注意11=11月
    LocalTime t2 = LocalTime.of(15, 16, 17); // 15:16:17
    LocalDateTime dt2 = LocalDateTime.of(2019, 11, 30, 15, 16, 17);
    LocalDateTime dt3 = LocalDateTime.of(d2, t2);
  }
}
