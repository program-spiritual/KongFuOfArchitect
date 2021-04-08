import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalDemo3 {

  public static void main(String[] args) {
    BigDecimal d1 = new BigDecimal("123.456");
    BigDecimal d2 = new BigDecimal("23.456789");
    BigDecimal d3 = d1.divide(d2, 10, RoundingMode.HALF_UP); // 保留10位小数并四舍五入
    BigDecimal d4 = d1.divide(d2); // 报错：ArithmeticException，因为除不尽
  }
}
