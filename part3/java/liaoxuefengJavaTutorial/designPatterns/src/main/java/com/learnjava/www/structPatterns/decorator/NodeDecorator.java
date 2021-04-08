package com.learnjava.www.structPatterns.decorator;

public abstract class NodeDecorator implements TextNode {

  protected final TextNode target;

  public NodeDecorator(TextNode target) {
    this.target = target;
  }

  public void setText(String text) {
    this.target.setText(text);
  }
}
