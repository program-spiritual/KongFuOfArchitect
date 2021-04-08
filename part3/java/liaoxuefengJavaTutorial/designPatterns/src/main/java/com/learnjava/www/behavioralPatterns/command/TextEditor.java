package com.learnjava.www.behavioralPatterns.command;

public class TextEditor {

  private StringBuilder buffer = new StringBuilder();

  public void copy() {}

  public void paste() {
    String text = getFromClipBoard();
    add(text);
  }

  public void add(String text) {
    buffer.append(text);
  }

  private String getFromClipBoard() {
    return "content from clipboard";
  }

  public void delete() {
    if (buffer.length() > 0) {
      buffer.deleteCharAt(buffer.length() - 1);
    }
  }

  public boolean getState() {
    return false;
  }
}
