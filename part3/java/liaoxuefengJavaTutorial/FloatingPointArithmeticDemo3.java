public class FloatingPointArithmeticDemo3 {
    public FloatingPointArithmeticDemo3() {
    }
//    如果参与运算的两个数其中一个是整型，那么整型可以自动提升到浮点型：
    public static void main(String[] args) {
        int n = 5;
        double d = 1.2 + 24.0 / n; // 6.0
        System.out.println(d);
        double f = 1.2 + 24 / 5; // 5.2
//        计算结果为5.2，原因是编译器计算24 / 5这个子表达式时，按两个整数进行运算，结果仍为整数4。
        System.out.println(f);

    }
}
