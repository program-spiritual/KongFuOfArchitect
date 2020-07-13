package useTreeMap;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        还有一种Map，它在内部会对Key进行排序，这种Map就是SortedMap。注意到SortedMap是接口，它的实现类是TreeMap。
//        遍历的顺序一定是"apple"、"orange"、"pear"，因为String默认按字母排序：
        Map<String, Integer> map = new TreeMap<>();
        map.put("orange", 1);
        map.put("apple", 2);
        map.put("pear", 3);
        for (String key : map.keySet()) {
            System.out.println(key);
        }
        // apple, orange, pear
    }
}
