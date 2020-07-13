public class extendsWildcardDemo3 {
    public static void main(String[] args) {
        //现在，我们只能定义：

        Pair3<Number> p1 = null;
        Pair3<Integer> p2 = new Pair3<>(1, 2);
        Pair3<Double> p3 = null;
//        因为Number、Integer和Double都符合<T extends Number>。
//
//        非Number类型将无法通过编译：

//        Pair3<String> param1 = null; //Error:(12, 15) java: 类型参数java.lang.String不在类型变量T的范围内
//        Pair3<Object> param2 = null; // Error:(13, 15) java: 类型参数java.lang.Object不在类型变量T的范围内
//        因为String、Object都不符合<T extends Number>，因为它们不是Number类型或Number的子类。
    }
}

//    在定义泛型类型Pair<T>的时候，也可以使用extends通配符来限定T的类型：

class Pair3<T extends Number> {


    public Pair3(T i, T i1) {

    }
}


