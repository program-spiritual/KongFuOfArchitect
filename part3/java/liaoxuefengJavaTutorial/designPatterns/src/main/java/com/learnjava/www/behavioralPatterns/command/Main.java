package com.learnjava.www.behavioralPatterns.command;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.add("Command pattern in text editor.\n");
// 执行一个CopyCommand:
        Command copy = new CopyCommand(editor);
        copy.execute();
        editor.add("----\n");
// 执行一个PasteCommand:
        Command paste = new PasteCommand(editor);
        paste.execute();
        System.out.println(editor.getState());
    }
}
