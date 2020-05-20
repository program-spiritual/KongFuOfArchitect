package io.inputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamDemo3 {
    public static void main(String[] args) {
        InputStream input = null;
        try {
            input = new FileInputStream("D:\\IdeaProjects\\KongFuOfArchitect\\part3\\java\\liaoxuefengJavaTutorial\\io\\inputstream\\readme.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int n = 0;
        try {
            n = input.read(); // 必须等待read()方法返回才能执行下一行代码
        } catch (IOException e) {
            e.printStackTrace();
        }
        int m = n;
//        执行到第二行代码时，必须等read()方法返回后才能继续。因为读取IO流相比执行普通代码，速度会慢很多，因此，无法确定read()方法调用到底要花费多长时间。
    }
}
