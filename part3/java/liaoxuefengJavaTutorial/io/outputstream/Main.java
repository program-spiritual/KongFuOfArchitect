package io.outputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Main {
    public static void main(String[] args) {
        OutputStream output = null;
        try {
            output = new FileOutputStream("D:\\IdeaProjects\\KongFuOfArchitect\\part3\\java\\liaoxuefengJavaTutorial\\io\\outputstream\\readme.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            output.write("Hello".getBytes("UTF-8")); // Hello
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
