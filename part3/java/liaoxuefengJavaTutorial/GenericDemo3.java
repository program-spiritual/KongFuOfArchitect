
import java.util.Arrays;

public class GenericDemo3 {
    public static void main(String[] args) {
        String[] ss = new String[] { "Orange", "Apple", "Pear" };
        Arrays.sort(ss);
        System.out.println(Arrays.toString(ss));
//        这是因为String本身已经实现了Comparable<String>接口。如果换成我们自定义的Person类型试试：
        PersonGeneric[] ps = new PersonGeneric[] {
                new PersonGeneric("Bob", 61),
                new PersonGeneric("Alice", 88),
                new PersonGeneric("Lily", 75),
        };
        Arrays.sort(ps);
        System.out.println(Arrays.toString(ps));
    }
}
//除了ArrayList<T>使用了泛型，还可以在接口中使用泛型。
//例如，Arrays.sort(Object[])可以对任意数组进行排序，
//但待排序的元素必须实现Comparable<T>这个泛型接口：

// interface Comparable<T> {
//    /**
//     * 返回-1: 当前实例比参数o小
//     * 返回0: 当前实例与参数o相等
//     * 返回1: 当前实例比参数o大
//     */
//    int compareTo(T o);
//}

class PersonGeneric implements Comparable<PersonGeneric> {
    String name;
    int score;

    PersonGeneric(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String toString() {
        return this.name + "," + this.score;
    }

    @Override
    public int compareTo( PersonGeneric o) {
        return this.name.compareTo(o.name);

    }


//    @Override
//    public int compareTo(@NotNull Object o) {
//        return 0;
//    }
}