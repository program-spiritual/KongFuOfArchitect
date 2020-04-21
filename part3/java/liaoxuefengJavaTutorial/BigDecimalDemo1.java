import java.math.BigDecimal;

public class BigDecimalDemo1 {
    public static void main(String[] args) {
//        和BigInteger类似，BigDecimal可以表示一个任意大小且精度完全准确的浮点数。
        BigDecimal bd = new BigDecimal("123.4567");
        System.out.println(bd.multiply(bd)); // 15241.55677489
//        BigDecimal用scale()表示小数位数，例如：
        BigDecimal d1 = new BigDecimal("123.45");
        BigDecimal d2 = new BigDecimal("123.4500");
        BigDecimal d3 = new BigDecimal("1234500");
        System.out.println(d1.scale()); // 2,两位小数
        System.out.println(d2.scale()); // 4
        System.out.println(d3.scale()); // 0

//        通过BigDecimal的stripTrailingZeros()方法，可以将一个BigDecimal格式化为一个相等的，但去掉了末尾0的BigDecimal：
        BigDecimal decimal01 = new BigDecimal("123.4500");
        BigDecimal decimal02 = decimal01.stripTrailingZeros();
        System.out.println(decimal01.scale()); // 4
        System.out.println(decimal02.scale()); // 2,因为去掉了00

        BigDecimal decimal03 = new BigDecimal("1234500");
        BigDecimal decimal04 = decimal03.stripTrailingZeros();
        System.out.println(d3.scale()); // 0
        System.out.println(decimal04.scale()); // -

//        如果一个BigDecimal的scale()返回负数，例如，-2，表示这个数是个整数，并且末尾有2个0。
//
    }
}
