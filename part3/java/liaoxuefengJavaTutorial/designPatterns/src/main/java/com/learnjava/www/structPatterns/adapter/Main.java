package com.learnjava.www.structPatterns.adapter;

import com.learnjava.www.structPatterns.adapter.Task;
import com.learnjava.www.structPatterns.adapter.RunnableAdapter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {
        Callable<Long> callable = new Task(123450000L);
//        Thread thread = new Thread(callable); // compile error!
        Thread thread = new Thread(new RunnableAdapter(callable));
        thread.start();

        String[] exist = new String[] {"Good", "morning", "Bob", "and", "Alice"};
        Set<String> set = new HashSet<>(Arrays.asList(exist));

        InputStream input = null;
        try {
            input = Files.newInputStream(Paths.get("/path/to/file"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Reader reader = null;
        try {
            reader = new InputStreamReader(input, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        readText(reader);
    }

    private static void readText(Reader reader) {

    }
}
