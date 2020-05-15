package collection.useList;

import java.util.List;

public class Array2List {
    public static void main(String[] args) {
        Integer[] array = { 1, 2, 3 };
//        通过List.of(T...)方法最简单
        List<Integer> list = List.of(array);
//        如果我们调用List.of()，它返回的是一个只读List：
    }
}
