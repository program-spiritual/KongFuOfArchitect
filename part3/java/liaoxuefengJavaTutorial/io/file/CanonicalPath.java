package io.file;

import java.io.File;
import java.io.IOException;

public class CanonicalPath {
    public static void main(String[] args) {
        File f = new File("..");
        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
        try {
            System.out.println(f.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
