package com.learnjava.www;

import java.math.BigInteger;
import java.util.stream.Stream;

public class UseStream {
    public static void main(String[] args) {
        Stream<BigInteger> naturals = createNaturalStream(); // 全体自然数
        Stream<BigInteger> streamNxN = naturals.map(n -> n.multiply(n)); // 全体自然数的平方

        naturals.map(n -> n.multiply(n)) // 1, 4, 9, 16, 25...
                .limit(100)
                .forEach(System.out::println);

        Stream<BigInteger> s2; // 不计算
//        s2 = naturals.map(BigInteger::multiply);
//        Stream<BigInteger> s3 = s2.limit(100); // 不计算
//        s3.forEach(System.out::println); // 计算



    }

//    temp method
    private static Stream<BigInteger> createNaturalStream() {
        return null;
    }
}
