package useCollections;

import java.util.Collections;
import java.util.List;

//注意Collections结尾多了一个s，不是Collection！
/**
 * Collections提供了一系列方法来创建空集合：
 *
 * 创建空List：List<T> emptyList()
 * 创建空Map：Map<K, V> emptyMap()
 * 创建空Set：Set<T> emptySet()
 * */
public class Main {
    public static void main(String[] args) {
        List<String> list1 = List.of();
        List<String> list2 = Collections.emptyList();
    }
}
