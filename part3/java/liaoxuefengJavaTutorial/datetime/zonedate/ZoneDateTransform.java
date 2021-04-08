package datetime.zonedate;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZoneDateTransform {

  public static void main(String[] args) {
    // 以中国时区获取当前时间:
    ZonedDateTime zbj = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
    // 转换为纽约时间:
    ZonedDateTime zny = zbj.withZoneSameInstant(ZoneId.of("America/New_York"));
    System.out.println(zbj);
    System.out.println(zny);
    //         涉及到时区时，千万不要自己计算时差，否则难以正确处理夏令时。
  }
}
