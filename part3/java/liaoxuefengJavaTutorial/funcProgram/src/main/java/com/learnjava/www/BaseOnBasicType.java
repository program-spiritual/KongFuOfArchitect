package com.learnjava.www;

import com.sun.tools.javac.util.List;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class BaseOnBasicType {
    public static void main(String[] args) {
        // 将int[]数组变为IntStream:
        IntStream is = Arrays.stream(new int[] { 1, 2, 3 });
// 将Stream<String>转换为LongStream:
        LongStream ls = List.of("1", "2", "3").stream().mapToLong(Long::parseLong);
        ls.limit(3).forEach(System.out::println);
    }
}
