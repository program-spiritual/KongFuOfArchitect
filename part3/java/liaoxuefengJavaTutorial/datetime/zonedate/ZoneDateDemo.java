package datetime.zonedate;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZoneDateDemo {

  public static void main(String[] args) {
    LocalDateTime ldt = LocalDateTime.of(2019, 9, 15, 15, 16, 17);
    ZonedDateTime zbj = ldt.atZone(ZoneId.systemDefault());
    ZonedDateTime zny = ldt.atZone(ZoneId.of("America/New_York"));
    System.out.println(zbj);
    System.out.println(zny);
  }
}
