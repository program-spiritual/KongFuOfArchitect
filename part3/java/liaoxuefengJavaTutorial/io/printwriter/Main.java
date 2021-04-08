package io.printwriter;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Main {

  public static void main(String[] args) {
    //PrintStream最终输出的总是byte数据，而PrintWriter则是扩展了Writer接口，
    //它的print()/println()方法最终输出的是char数据。两者的使用方法几乎是一模一样的：
    StringWriter buffer = new StringWriter();
    try (PrintWriter pw = new PrintWriter(buffer)) {
      pw.println("Hello");
      pw.println(12345);
      pw.println(true);
    }
    System.out.println(buffer.toString());
  }
}
