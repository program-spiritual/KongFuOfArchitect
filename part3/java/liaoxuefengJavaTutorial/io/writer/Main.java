package io.writer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

public class Main {

  public static void main(String[] args) {
    try {
      try (
        Writer writer = new FileWriter(
          "part3\\java\\liaoxuefengJavaTutorial\\io\\writer\\write.txt",
          StandardCharsets.UTF_8
        )
      ) {
        writer.write('H'); // 写入单个字符
        writer.write("Hello".toCharArray()); // 写入char[]
        writer.write("Hello"); // 写入String
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
