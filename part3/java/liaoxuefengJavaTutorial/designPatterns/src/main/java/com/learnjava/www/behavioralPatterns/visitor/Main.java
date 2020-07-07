package com.learnjava.www.behavioralPatterns.visitor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
//        FileStructure fs = new FileStructure(new File("."));
//        fs.handle(new JavaFileVisitor());
        try {
            Files.walkFileTree(Paths.get("."), new FileVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
