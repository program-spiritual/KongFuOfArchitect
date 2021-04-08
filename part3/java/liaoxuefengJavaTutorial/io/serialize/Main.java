package io.serialize;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    //        序列化后可以把byte[]保存到文件中，或者把byte[]通过网络传输到远程，这样，就相当于把Java对象存储到文件或者通过网络传输出去了。
    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    try {
      try (ObjectOutputStream output = new ObjectOutputStream(buffer)) {
        // 写入int:
        output.writeInt(12345);
        // 写入String:
        output.writeUTF("Hello");
        // 写入Object:
        output.writeObject(Double.valueOf(123.456));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println(Arrays.toString(buffer.toByteArray()));
  }
}
