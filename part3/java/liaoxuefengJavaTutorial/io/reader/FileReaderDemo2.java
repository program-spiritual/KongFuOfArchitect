package io.reader;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public class FileReaderDemo2 {

  public static void main(String[] args) {
    try {
      Reader reader = new FileReader(
        "part3\\java\\liaoxuefengJavaTutorial\\io\\reader\\readme.txt",
        StandardCharsets.UTF_8
      );
      char[] buffer = new char[1000];
      int n;
      while ((n = reader.read(buffer)) != -1) {
        System.out.println("read " + n + " chars.");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
