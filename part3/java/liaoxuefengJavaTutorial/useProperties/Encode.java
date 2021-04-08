package useProperties;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class Encode {

  public static void main(String[] args) {
    Properties props = new Properties();
    try {
      props.load(
        new FileReader("C:\\setting.properties", StandardCharsets.UTF_8)
      );
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
