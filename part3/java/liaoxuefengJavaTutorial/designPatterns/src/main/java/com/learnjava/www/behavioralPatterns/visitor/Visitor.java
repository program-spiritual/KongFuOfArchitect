package com.learnjava.www.behavioralPatterns.visitor;

import java.io.File;

public interface Visitor {
  // 访问文件夹:
  void visitDir(File dir);
  // 访问文件:
  void visitFile(File file);
}
