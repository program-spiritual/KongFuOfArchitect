package com.itranswarp.learnjava;

import com.itranswarp.learnjava.service.User;
import com.itranswarp.learnjava.service.UserService;
import java.time.ZoneId;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
@PropertySource("app.properties") // 表示读取classpath的app.properties
@EnableAspectJAutoProxy
public class AppConfig {

  @Bean
  @Profile("!test")
  ZoneId createZoneId() {
    return ZoneId.systemDefault();
  }

  @Bean
  @Profile("test")
  ZoneId createZoneIdForTest() {
    return ZoneId.of("America/New_York");
  }

  @Bean
  @Profile({ "test", "master" }) // 同时满足test和master
  ZoneId createZoneIdForAll() {
    return ZoneId.of("Asia/ShangHai");
  }

  @Value("${app.zone:Z}")
  String zoneId;

  @Bean
  ZoneId createZoneId(@Value("${app.zone:Z}") String zoneId) {
    return ZoneId.of(zoneId);
  }

  @Bean("z")
  @Primary
  ZoneId createZoneOfZ() {
    return ZoneId.of("Z");
  }

  @Bean
  @Qualifier("utc8")
  ZoneId createZoneOfUTC8() {
    return ZoneId.of("UTC+08:00");
  }

  public static void main(String[] args) {
    try {
      ApplicationContext context = new AnnotationConfigApplicationContext(
        AppConfig.class
      );
      UserService userService = context.getBean(UserService.class);
      User user = userService.login("bob@example.com", "password");
      System.out.println(user.getName());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
