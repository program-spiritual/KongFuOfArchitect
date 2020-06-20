package com.learnjava.www;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class BaseOnSupplier {
    public static void main(String[] args) {
//        对于无限序列，如果直接调用forEach()或者count()这些最终求值操作，
//       会进入死循环，因为永远无法计算完这个序列，所以正确的方法是先把无限序列变成有限序列，
//      例如，用limit()方法可以截取前面若干个元素，这样就变成了一个有限序列，对这个有限序列调用forEach()或者count()操作就没有问题。
        Stream<Integer> natual = Stream.generate(new NatualSupplier());
        // 注意：无限序列必须先变成有限序列再打印:
        natual.limit(20).forEach(System.out::println);
    }
}
//

class NatualSupplier implements Supplier<Integer> {
    int n = 0;
    public Integer get() {
        n++;
        return n;
    }
}
