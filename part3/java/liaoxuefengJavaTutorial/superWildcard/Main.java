package superWildcard;

public class Main {
    public static void main(String[] args) {
        Pair<Number> p1 = new Pair<>(12.3, 4.56);
        Pair<Integer> p2 = new Pair<>(123, 456);
        setSame(p1, 100);
        setSame(p2, 200);
        System.out.println(p1.getFirst() + ", " + p1.getLast());
        System.out.println(p2.getFirst() + ", " + p2.getLast());
    }
    static void setSame(Pair<? super Integer> p, Integer n) {
//        注意到Pair<? super Integer>表示，方法参数接受所有泛型类型为Integer或Integer父类的Pair类型。
        p.setFirst(n);
        p.setLast(n);
    }
}
//因此，使用<? super Integer>通配符表示：
//
//允许调用set(? super Integer)方法传入Integer的引用；
//
//不允许调用get()方法获得Integer的引用。
//
//唯一例外是可以获取Object的引用：Object o = p.getFirst()。
//换句话说，使用<? super Integer>通配符作为方法参数，表示方法内部代码对于参数只能写，不能读。

//<? extends T>类型和<? super T>类型的区别在于：
//
//<? extends T>允许调用读方法T get()获取T的引用，但不允许调用写方法set(T)传入T的引用（传入null除外）；
//
//<? super T>允许调用写方法set(T)传入T的引用，但不允许调用读方法T get()获取T的引用（获取Object除外）。