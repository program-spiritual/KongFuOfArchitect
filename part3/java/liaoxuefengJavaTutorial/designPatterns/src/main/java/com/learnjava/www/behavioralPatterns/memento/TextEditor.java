package com.learnjava.www.behavioralPatterns.memento;


/**
 * 标准的备忘录模式有这么几种角色：
 *
 * Memonto：存储的内部状态；
 * Originator：创建一个备忘录并设置其状态；
 * Caretaker：负责保存备忘录。
 * 实际上我们在使用备忘录模式的时候，不必设计得这么复杂，只需要对类似TextEditor的类，增加getState()和setState()就可以了。
 * */
public class TextEditor {
    private StringBuilder buffer = new StringBuilder();

    public void add(char ch) {
        buffer.append(ch);
    }

    public void add(String s) {
        buffer.append(s);
    }

    public void delete() {
        if (buffer.length() > 0) {
            buffer.deleteCharAt(buffer.length() - 1);
        }
    }

    // 获取状态:
    public String getState() {
        return buffer.toString();
    }

    // 恢复状态:
    public void setState(String state) {
        this.buffer.delete(0, this.buffer.length());
        this.buffer.append(state);
    }
}
