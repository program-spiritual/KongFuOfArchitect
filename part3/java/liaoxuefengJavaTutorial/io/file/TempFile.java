package io.file;

import java.io.File;
import java.io.IOException;

public class TempFile {

  public static void main(String[] args) {
    File f = null; // 提供临时文件的前缀和后缀
    try {
      f = File.createTempFile("tmp-", ".txt");
    } catch (IOException e) {
      e.printStackTrace();
    }
    f.deleteOnExit(); // JVM退出时自动删除
    System.out.println(f.isFile());
    System.out.println(f.getAbsolutePath());
  }
}
