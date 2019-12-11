object scala_bitwise_operators {
  def main(args: Array[String]): Unit = {
    val a = 60
    /* 60 = 0011 1100 */
    val b = 13
    /* 13 = 0000 1101 */
    var c = 0

    c = a & b /* 12 = 0000 1100 */
    println("a & b = " + c)

    c = a | b /* 61 = 0011 1101 */
    println("a | b = " + c)

    c = a ^ b /* 49 = 0011 0001 */
    println("a ^ b = " + c)

    c = ~a /* -61 = 1100 0011 */
    println("~a = " + c)

    c = a << 2 /* 240 = 1111 0000 */
    println("a << 2 = " + c)
//二元右移运算符
    c = a >> 2 /* 215 = 1111 */
    println("a >> 2  = " + c)
//右移零填充运算符
    c = a >>> 2 /* 215 = 0000 1111 */
    println("a >>> 2 = " + c)
  }
}
