package io.inputstream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamDemo2 {

  public static void main(String[] args) {
    try {
      try (
        InputStream input = new FileInputStream(
          "D:\\IdeaProjects\\KongFuOfArchitect\\part3\\java\\liaoxuefengJavaTutorial\\io\\inputstream\\readme.txt"
        )
      ) {
        // 定义1000个字节大小的缓冲区:
        byte[] buffer = new byte[1000];
        int n;
        while ((n = input.read(buffer)) != -1) { // 读取到缓冲区
          System.out.println("read " + n + " bytes.");
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
