public class WriteGenericsDemo2 {
    public static void main(String[] args) {
//使用的时候，需要指出两种类型：
        Pair2<String, Integer> p = new Pair2<>("test", 123);
        System.out.println(p);
    }
}


//泛型还可以定义多种类型。例如，我们希望Pair不总是存储两个类型一样的对象，就可以使用类型<T, K>：
class Pair2<T, K> {
    private T first;
    private K last;

    public Pair2(T first, K last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }

    public K getLast() {
        return last;
    }
}