package iterator.basic;

import java.util.ArrayList;
import java.util.Iterator;

public class Compare {
    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<String>();
        names.add("xzg");
        names.add("wang");
        names.add("zheng");

// 第一种遍历方式：for循环
        for (int i = 0; i < names.size(); i++) {
            System.out.print(names.get(i) + ",");
        }

// 第二种遍历方式：foreach循环
        for (String name : names) {
            System.out.print(name + ",");
        }

// 第三种遍历方式：迭代器遍历
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ",");//Java中的迭代器接口是第二种定义方式，next()既移动游标又返回数据
        }
    }
}
