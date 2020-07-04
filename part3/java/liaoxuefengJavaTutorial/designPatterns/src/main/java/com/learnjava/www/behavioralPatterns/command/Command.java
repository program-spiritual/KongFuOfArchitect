package com.learnjava.www.behavioralPatterns.command;

public interface Command {
    void execute();

    void undo();

    void redo();
}
