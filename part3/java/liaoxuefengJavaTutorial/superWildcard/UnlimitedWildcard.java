package superWildcard;

public class UnlimitedWildcard {
    public static void main(String[] args) {
//        <?>通配符有一个独特的特点，就是：Pair<?>是所有Pair<T>的超类：
        Pair<Integer> p = new Pair<>(123, 456);
        Pair<?> p2 = p; // 安全地向上转型
        System.out.println(p2.getFirst() + ", " + p2.getLast());
    }
    static boolean isNull(Pair<?> p) {
    //因为<?>通配符既没有extends，也没有super，因此：
    //不允许调用set(T)方法并传入引用（null除外）；
    //不允许调用T get()方法并获取T引用（只能获取Object引用）
//        换句话说，既不能读，也不能写，那只能做一些null判断：
        return p.getFirst() == null || p.getLast() == null;
    }
}

