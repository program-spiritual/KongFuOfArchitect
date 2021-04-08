package io.filterinputstream;

import java.io.*;

public class Main {

  public static void main(String[] args) {
    byte[] data = new byte[0];
    try {
      data = "hello, world!".getBytes("UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    try {
      try (
        CountInputStream input = new CountInputStream(
          new ByteArrayInputStream(data)
        )
      ) {
        int n;
        while ((n = input.read()) != -1) {
          System.out.println((char) n);
        }
        System.out.println("Total read " + input.getBytesRead() + " bytes");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

class CountInputStream extends FilterInputStream {

  private int count = 0;

  CountInputStream(InputStream in) {
    super(in);
  }

  public int getBytesRead() {
    return this.count;
  }

  public int read() throws IOException {
    int n = in.read();
    if (n != -1) {
      this.count++;
    }
    return n;
  }

  public int read(byte[] b, int off, int len) throws IOException {
    int n = in.read(b, off, len);
    this.count += n;
    return n;
  }
}
