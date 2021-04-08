package io.inputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamDemo1 {

  public static void main(String[] args) {
    //        InputStream并不是一个接口，而是一个抽象类，它是所有输入流的超类。
    //        read()方法会读取输入流的下一个字节，并返回字节表示的int值（0~255）。如果已读到末尾，返回-1表示不能继续读取了。
    //        FileInputStream是InputStream的一个子类
    // 创建一个FileInputStream对象:
    InputStream input = null;
    try {
      input =
        new FileInputStream(
          "D:\\IdeaProjects\\KongFuOfArchitect\\part3\\java\\liaoxuefengJavaTutorial\\io\\inputstream\\readme.txt"
        );
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    for (;;) {
      int n = 0; // 反复调用read()方法，直到返回-1
      try {
        n = input.read();
      } catch (IOException e) {
        e.printStackTrace();
      }
      if (n == -1) {
        break;
      }
      System.out.println(n); // 打印byte的值
    }
    try {
      //            InputStream和OutputStream都是通过close()方法来关闭流。关闭流就会释放对应的底层资源。
      //            编译器并不会特别地为InputStream加上自动关闭。
      //           编译器只看try(resource = ...)中的对象是否实现了java.lang.AutoCloseable接口，
      //           如果实现了，就自动加上finally语句并调用close()方法。
      //          InputStream和OutputStream都实现了这个接口，
      //         因此，都可以用在try(resource)中。
      input.close(); // 关闭流
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
