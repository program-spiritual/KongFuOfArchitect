package com.learnjava.www.structPatterns.decorator;

public class BoldDecorator extends NodeDecorator {

  public BoldDecorator(TextNode target) {
    super(target);
  }

  @Override
  public String getText() {
    return "<b>" + target.getText() + "</b>";
  }
}
