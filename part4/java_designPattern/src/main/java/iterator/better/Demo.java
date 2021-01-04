package iterator.better;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


public class Demo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("a");
        names.add("b");
        names.add("c");
        names.add("d");

        Iterator<String> iterator1 = names.iterator();
        Iterator<String> iterator2 = names.iterator();
        iterator1.next();
        iterator1.remove();
        iterator2.next(); // 运行结果？  ConcurrentModificationException
    }
}
