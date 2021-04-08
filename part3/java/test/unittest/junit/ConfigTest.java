package unittest.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

public class ConfigTest {

  @Test
  @EnabledOnOs(OS.WINDOWS)
  void testWindows() {
    Config config = new Config();
    Assertions.assertEquals("C:\\test.ini", config.getConfigFile("test.ini"));
  }

  @Test
  @EnabledOnOs({ OS.LINUX, OS.MAC })
  void testLinuxAndMac() {
    Config config = new Config();
    Assertions.assertEquals(
      "/usr/local/test.cfg",
      config.getConfigFile("test.cfg")
    );
  }

  @Test
  @DisabledOnOs(OS.WINDOWS)
  void testOnNonWindowsOs() {
    // TODO: this test is disabled on windows
  }

  @Test
  @DisabledOnJre(JRE.JAVA_8)
  void testOnJava9OrAbove() {
    // TODO: this test is disabled on java 8
  }

  @Test
  @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
  void testOnlyOn64bitSystem() {
    // TODO: this test is only run on 64 bit system
  }

  @Test
  @EnabledIfEnvironmentVariable(named = "DEBUG", matches = "true")
  void testOnlyOnDebugMode() {
    // TODO: this test is only run on DEBUG=true
  }

  @Test
  @EnabledIf(
    "java.time.LocalDate.now().getDayOfWeek()==java.time.DayOfWeek.SUNDAY"
  )
  void testOnlyOnSunday() {
    // TODO: this test is only run on Sunday
  }
}
