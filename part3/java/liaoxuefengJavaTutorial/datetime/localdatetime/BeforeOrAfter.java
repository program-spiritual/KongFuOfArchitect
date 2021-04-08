package datetime.localdatetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class BeforeOrAfter {

  public static void main(String[] args) {
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime target = LocalDateTime.of(2019, 11, 19, 8, 15, 0);
    System.out.println(now.isBefore(target));
    System.out.println(LocalDate.now().isBefore(LocalDate.of(2019, 11, 19)));
    System.out.println(LocalTime.now().isAfter(LocalTime.parse("08:15:00")));
  }
}
