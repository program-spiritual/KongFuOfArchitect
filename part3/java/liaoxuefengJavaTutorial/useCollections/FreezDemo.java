package useCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
* Collections还提供了一组方法把可变集合封装成不可变集合：

封装成不可变List：List<T> unmodifiableList(List<? extends T> list)
封装成不可变Set：Set<T> unmodifiableSet(Set<? extends T> set)
封装成不可变Map：Map<K, V> unmodifiableMap(Map<? extends K, ? extends V> m)
*
* */
public class FreezDemo {
    public static void main(String[] args) {
        List<String> mutable = new ArrayList<>();
        mutable.add("apple");
        mutable.add("pear");
        // 变为不可变集合:
        List<String> immutable = Collections.unmodifiableList(mutable);
        // 立刻扔掉mutable的引用:
        mutable = null;
        System.out.println(immutable);
        immutable.add("orange"); // UnsupportedOperationException!

    }
}
