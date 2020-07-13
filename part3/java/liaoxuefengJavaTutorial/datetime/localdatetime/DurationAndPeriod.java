package datetime.localdatetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class DurationAndPeriod {
    public static void main(String[] args) {

//        Duration表示两个时刻之间的时间间隔。另一个类似的Period表示两个日期之间的天数：
        LocalDateTime start = LocalDateTime.of(2019, 11, 19, 8, 15, 0);
        LocalDateTime end = LocalDateTime.of(2020, 1, 9, 19, 25, 30);
        Duration d = Duration.between(start, end);
        System.out.println(d); // PT1235H10M30S

        Period p = LocalDate.of(2019, 11, 19).until(LocalDate.of(2020, 1, 9));
        System.out.println(p); // P1M21D

//        注意到两个LocalDateTime之间的差值使用Duration表示，
//       类似PT1235H10M30S，表示1235小时10分钟30秒。
//      而两个LocalDate之间的差值用Period表示，类似P1M21D，表示1个月21天。

//        P...T之间表示日期间隔，T后面表示时间间隔。如果是PT...的格式表示仅有时间间隔。利用ofXxx()或者parse()方法也可以直接创建Duration
        Duration d1 = Duration.ofHours(10); // 10 hours
        Duration d2 = Duration.parse("P1DT2H3M"); // 1 day, 2 hours, 3 minutes
    }
}
