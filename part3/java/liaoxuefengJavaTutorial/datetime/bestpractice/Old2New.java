package datetime.bestpractice;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class Old2New {
    public static void main(String[] args) {
        // Date -> Instant:
//        如果要把旧式的Date或Calendar转换为新API对象，
//       可以通过toInstant()方法转换为Instant对象，再继续转换为ZonedDateTime：
        Instant ins1 = new Date().toInstant();

// Calendar -> Instant -> ZonedDateTime:
        Calendar calendar = Calendar.getInstance();
        Instant ins2 = Calendar.getInstance().toInstant();
        ZonedDateTime zdt = ins2.atZone(calendar.getTimeZone().toZoneId());
    }
}
