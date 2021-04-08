package datetime.bestpractice;

import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class New2Old {

  public static void main(String[] args) {
    //如果要把新的ZonedDateTime转换为旧的API对象，只能借助long型时间戳做一个“中转”
    // ZonedDateTime -> long:
    ZonedDateTime zdt = ZonedDateTime.now();
    long ts = zdt.toEpochSecond() * 1000;

    // long -> Date:
    Date date = new Date(ts);

    // long -> Calendar:
    Calendar calendar = Calendar.getInstance();
    calendar.clear();
    calendar.setTimeZone(TimeZone.getTimeZone(zdt.getZone().getId()));
    calendar.setTimeInMillis(zdt.toEpochSecond() * 1000);
  }
}
