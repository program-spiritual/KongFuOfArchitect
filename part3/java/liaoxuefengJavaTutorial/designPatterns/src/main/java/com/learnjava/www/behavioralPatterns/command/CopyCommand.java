package com.learnjava.www.behavioralPatterns.command;

public class CopyCommand implements Command {
    // 持有执行者对象:
    private TextEditor receiver;

    public CopyCommand(TextEditor receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.copy();
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
}
