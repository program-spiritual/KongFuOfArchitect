package com.learnjava.www;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        从Java 8开始，我们可以用Lambda表达式替换单方法接口。改写上述代码如下：
        String[] array = new String[] { "Apple", "Orange", "Banana", "Lemon" };
        Arrays.sort(array, (s1, s2) -> {
            return s1.compareTo(s2);
        });
        System.out.println(String.join(", ", array));

    }
}

//        我们把只定义了单方法的接口称之为FunctionalInterface，用注解@FunctionalInterface标记。例如，Callable接口：

@FunctionalInterface
 interface CallableDemo<V> {
    V call() throws Exception;
}