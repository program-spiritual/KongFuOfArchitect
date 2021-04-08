package com.learnjava.www.behavioralPatterns.command;

public class PasteCommand implements Command {

  private TextEditor receiver;

  public PasteCommand(TextEditor receiver) {
    this.receiver = receiver;
  }

  public void execute() {
    receiver.paste();
  }

  @Override
  public void undo() {}

  @Override
  public void redo() {}
}
