package io.zip;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Write {
    public static void main(String[] args) {
//        ZipOutputStream是一种FilterOutputStream，它可以直接写入内容到zip包。
//       我们要先创建一个ZipOutputStream，通常是包装一个FileOutputStream，
//       然后，每写入一个文件前，先调用putNextEntry()，然后用write()写入byte[]数据，
//      写入完毕后调用closeEntry()结束这个文件的打包。

        try {
            try (ZipOutputStream zip = new ZipOutputStream(new FileOutputStream("out.zip"))) {
                File[] files = {
                        new File("D:\\IdeaProjects\\KongFuOfArchitect\\part3\\java\\liaoxuefengJavaTutorial\\io\\zip\\a.txt"),
                        new File("D:\\IdeaProjects\\KongFuOfArchitect\\part3\\java\\liaoxuefengJavaTutorial\\io\\zip\\b.txt")
                };
                for (File f : files) {
                    zip.putNextEntry(new ZipEntry(f.getName()));
                    zip.write(getFileDataAsBytes(f));
                    zip.closeEntry();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static byte[] getFileDataAsBytes(File f) {
        InputStream input = null;
        try {
            input = new FileInputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 定义1000个字节大小的缓冲区:
        byte[] buffer = new byte[1000];
        int n;
        while (true) {
            try {
                if (!((n = input.read(buffer)) != -1)) break;
                System.out.println("read " + n + " bytes.");

            } catch (IOException e) {
                e.printStackTrace();
            } // 读取到缓冲区
        }

        return buffer;

    }
}
