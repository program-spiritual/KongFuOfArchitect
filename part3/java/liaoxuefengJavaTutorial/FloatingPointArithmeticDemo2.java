public class FloatingPointArithmeticDemo2 {
    public FloatingPointArithmeticDemo2() {
    }

    public static void main(String[] args) {
        double x = 1.0 / 10;
        double y = 1 - 9.0 / 10;
        // 比较x和y是否相等，先计算其差的绝对值:
        double r = Math.abs(x - y);
        // 再判断绝对值是否足够小:
        if (r < 0.00001) {
            System.out.println("equals");
            // 可以认为相等
        } else {
            // 不相等
            System.out.println("not equals");
        }
    }
}
