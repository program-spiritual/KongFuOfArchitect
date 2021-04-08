package datetime.instance;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

//Instant表示高精度时间戳，它可以和ZonedDateTime以及long互相转换。
public class Main {

  //    计算机存储的当前时间，本质上只是一个不断递增的整数。Java提供的System.currentTimeMillis()返回的就是以毫秒表示的当前时间戳。
  //    用Instant.now()获取当前时间戳，效果和System.currentTimeMillis()类似：
  public static void main(String[] args) {
    Instant now = Instant.now();
    System.out.println(now.getEpochSecond()); // 秒
    System.out.println(now.toEpochMilli()); // 毫秒
    // 以指定时间戳创建Instant:
    Instant ins = Instant.ofEpochSecond(1568568760);
    ZonedDateTime zdt = ins.atZone(ZoneId.systemDefault());
    System.out.println(zdt); // 2019-09-16T01:32:40+08:00[Asia/Shanghai]
    /**
     * 可见，对于某一个时间戳，给它关联上指定的ZoneId，就得到了ZonedDateTime，继而可以获得了对应时区的LocalDateTime。
     *
     * 所以，LocalDateTime，ZoneId，Instant，ZonedDateTime和long都可以互相转换：
     *
     * ┌─────────────┐
     * │LocalDateTime│────┐
     * └─────────────┘    │    ┌─────────────┐
     *                    ├───>│ZonedDateTime│
     * ┌─────────────┐    │    └─────────────┘
     * │   ZoneId    │────┘           ▲
     * └─────────────┘      ┌─────────┴─────────┐
     *                      │                   │
     *                      ▼                   ▼
     *               ┌─────────────┐     ┌─────────────┐
     *               │   Instant   │<───>│    long     │
     *               └─────────────┘     └─────────────┘
     * 转换的时候，只需要留意long类型以毫秒还是秒为单位即可。
     *
     * */
  }
}
