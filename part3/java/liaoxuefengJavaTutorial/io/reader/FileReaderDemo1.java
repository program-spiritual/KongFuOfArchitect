package io.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public class FileReaderDemo1 {
    public static void main(String[] args) {
        // 创建一个FileReader对象:
        Reader reader = null; // 字符编码是???
        try {
//            要避免乱码问题，我们需要在创建FileReader时指定编码
            reader = new FileReader("part3\\java\\liaoxuefengJavaTutorial\\io\\reader\\readme.txt", StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (;;) {
            int n = 0; // 反复调用read()方法，直到返回-1
            try {
                n = reader.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (n == -1) {
                break;
            }
            System.out.println((char)n); // 打印char
        }
        try {
            reader.close(); // 关闭流
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
