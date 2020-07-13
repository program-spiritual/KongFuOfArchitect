package io.file;

import java.io.File;


public class PathBase {
    public static void main(String[] args) {
//        构造File对象时，既可以传入绝对路径，也可以传入相对路径。绝对路径是以根目录开头的完整路径，例如：

        File f = new File("C:\\Windows\\notepad.exe");
//注意Windows平台使用\作为路径分隔符，在Java字符串中需要用\\表示一个\。Linux平台使用/作为路径分隔符：
//
        File f2 = new File("/usr/bin/javac");
//        传入相对路径时，相对路径前面加上当前目录就是绝对路径：

// 假设当前目录是C:\Docs
        File f1 = new File("sub\\javac"); // 绝对路径是C:\Docs\sub\javac
        File f3 = new File(".\\sub\\javac"); // 绝对路径是C:\Docs\sub\javac
        File f4 = new File("..\\sub\\javac"); // 绝对路径是C:\sub\javac
    }
}
