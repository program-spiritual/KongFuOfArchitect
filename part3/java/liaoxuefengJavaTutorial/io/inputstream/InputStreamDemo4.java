package io.inputstream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamDemo4 {

  public static void main(String[] args) {
    byte[] data = { 72, 101, 108, 108, 111, 33 };
    try {
      try (InputStream input = new ByteArrayInputStream(data)) {
        String s = null;
        try {
          s = readAsString(input);
        } catch (IOException e) {
          e.printStackTrace();
        }
        System.out.println(s);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static String readAsString(InputStream input) throws IOException {
    int n;
    StringBuilder sb = new StringBuilder();
    while ((n = input.read()) != -1) {
      sb.append((char) n);
    }
    return sb.toString();
  }
}
