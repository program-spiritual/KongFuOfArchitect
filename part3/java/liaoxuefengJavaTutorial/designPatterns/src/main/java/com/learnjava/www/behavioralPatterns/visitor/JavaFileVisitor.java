package com.learnjava.www.behavioralPatterns.visitor;

import java.io.File;

public class JavaFileVisitor implements Visitor {

  @Override
  public void visitDir(File dir) {
    System.out.println("Visit dir: " + dir);
  }

  @Override
  public void visitFile(File file) {
    if (file.getName().endsWith(".java")) {
      System.out.println("Found java file: " + file);
    }
  }
}
