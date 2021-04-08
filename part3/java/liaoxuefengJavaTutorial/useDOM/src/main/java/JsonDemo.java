import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;

public class JsonDemo {

  public static void main(String[] args) {
    InputStream input = Main.class.getResourceAsStream("/book.json");
    ObjectMapper mapper = new ObjectMapper();
    // 反序列化时忽略不存在的JavaBean属性:
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    try {
      Book book = mapper.readValue(input, Book.class);
      String json = mapper.writeValueAsString(book);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
