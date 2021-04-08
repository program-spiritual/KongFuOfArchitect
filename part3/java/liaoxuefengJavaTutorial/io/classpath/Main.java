package io.classpath;

import java.io.IOException;
import java.io.InputStream;

public class Main {

  //    有没有路径无关的读取文件的方式呢？
  //    在classpath中的资源文件，路径总是以／开头，我们先获取当前的Class对象，然后调用getResourceAsStream()就可以直接从classpath读取任意的资源文件：
  public static void main(String[] args) {
    try {
      try (
        InputStream input = Main.class.getResourceAsStream(
            "/default.properties"
          )
      ) {
        if (input != null) {
          // TODO:
          System.out.println("已找到该文件");
        } else {
          System.out.println("文件未找到");
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
