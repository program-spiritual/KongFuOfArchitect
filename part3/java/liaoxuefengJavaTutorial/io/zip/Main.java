package io.zip;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Main {
    public static void main(String[] args) {
        try {
            try (ZipInputStream zip = new ZipInputStream(new FileInputStream("D:\\IdeaProjects\\KongFuOfArchitect\\part3\\java\\liaoxuefengJavaTutorial\\io\\zip\\readme.zip"))) {
                ZipEntry entry = null;
                while ((entry = zip.getNextEntry()) != null) {
                    String name = entry.getName();
                    if (!entry.isDirectory()) {
                        int n;
                        while ((n = zip.read()) != -1) {
                            System.out.println(n);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
