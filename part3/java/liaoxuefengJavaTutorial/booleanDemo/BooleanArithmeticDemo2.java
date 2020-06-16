package booleanDemo;

public class BooleanArithmeticDemo2 {
    public static void main(String[] args) {
        int n = -100;
        int x = n >= 0 ? n : -n;
        System.out.println(x);
//        n >= 0是否成立，如果为true，则返回n，否则返回-n。这实际上是一个求绝对值的表达式。
//
//注意到三元运算b ? x : y会首先计算b，如果b为true，则只计算x，否则，只计算y。此外，x和y的类型必须相同，因为返回值不是boolean，而是x和y之一。
    }
}
