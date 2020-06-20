package com.learnjava.www;

import com.sun.tools.javac.util.List;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamDemo2 {
    public static void main(String[] args) {
        Stream<String> stream1 = Arrays.stream(new String[] { "A", "B", "C" });
        Stream<String> stream2 = List.of("X", "Y", "Z").stream();
        stream1.forEach(System.out::println);
        stream2.forEach(System.out::println);
    }
}
