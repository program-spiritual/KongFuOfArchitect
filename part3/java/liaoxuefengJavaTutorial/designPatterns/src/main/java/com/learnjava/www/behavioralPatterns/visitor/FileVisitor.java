package com.learnjava.www.behavioralPatterns.visitor;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FileVisitor extends SimpleFileVisitor<Path> {

  // 处理Directory:
  public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
    throws IOException {
    System.out.println("pre visit dir: " + dir);
    // 返回CONTINUE表示继续访问:
    return FileVisitResult.CONTINUE;
  }

  // 处理File:
  public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
    throws IOException {
    System.out.println("visit file: " + file);
    // 返回CONTINUE表示继续访问:
    return FileVisitResult.CONTINUE;
  }
}
