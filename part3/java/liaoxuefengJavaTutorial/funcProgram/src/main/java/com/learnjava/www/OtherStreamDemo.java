package com.learnjava.www;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class OtherStreamDemo {

  public static void main(String[] args) {
    baseOnPattern();
  }

  static void baseOnAPI() {
    try {
      try (
        Stream<String> lines = Files.lines(Paths.get("/path/to/file.txt"))
      ) {}
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void baseOnPattern() {
    Pattern p = Pattern.compile("\\s+");
    Stream<String> s = p.splitAsStream(
      "The quick brown fox jumps over the lazy dog"
    );
    s.forEach(System.out::println);
  }
}
