package bigdecimal;

import java.math.BigDecimal;

public class BigDecimalDemo4 {
    public static void main(String[] args) {
        BigDecimal n = new BigDecimal("12.345");
        BigDecimal m = new BigDecimal("0.12");
        BigDecimal[] dr = n.divideAndRemainder(m);
        System.out.println(dr[0]); // 102
        System.out.println(dr[1]); // 0.105
//        调用divideAndRemainder()方法时，返回的数组包含两个BigDecimal，
//       分别是商和余数，其中商总是整数，余数不会大于除数。
//      我们可以利用这个方法判断两个BigDecimal是否是整数倍数：
        if (dr[1].signum() == 0) {
            // n是m的整数倍
        }
    }
}
