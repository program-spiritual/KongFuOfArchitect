package io.reader;

import java.io.*;

public class FileReaderDemo3 {

  public static void main(String[] args) {
    //        既然Reader本质上是一个基于InputStream的byte到char的转换器，
    //       那么，如果我们已经有一个InputStream，想把它转换为Reader，是完全可行的。
    //      InputStreamReader就是这样一个转换器，它可以把任何InputStream转换为Reader。示例代码如下：
    // 持有InputStream:
    InputStream input = null;
    try {
      input =
        new FileInputStream(
          "part3\\java\\liaoxuefengJavaTutorial\\io\\reader\\readme.txt"
        );
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    // 变换为Reader:
    try {
      Reader reader = new InputStreamReader(input, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }
}
