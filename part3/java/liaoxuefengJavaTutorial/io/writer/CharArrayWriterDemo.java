package io.writer;

import java.io.CharArrayWriter;

public class CharArrayWriterDemo {

  public static void main(String[] args) {
    try (CharArrayWriter writer = new CharArrayWriter()) {
      writer.write(65);
      writer.write(66);
      writer.write(67);
      char[] data = writer.toCharArray(); // { 'A', 'B', 'C' }
    }
  }
}
