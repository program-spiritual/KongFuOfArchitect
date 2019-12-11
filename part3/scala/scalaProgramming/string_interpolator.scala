object string_interpolator {
  def main(args: Array[String]): Unit = {
    val name = "James"

    println(s"Hello, $name")
//    s 插值
    println(s"1 + 1 = ${1 + 1}")

    val height = 1.9d
    val name2 = "James"
    println(f"$name2%s is $height%2.2f meters tall") //James is 1.90 meters tall
//    row
//    在's'用法的输出中，\ n作为新行起作用，而在'raw'用法的输出中，'\ n'不起作用。它将打印带有转义字母的完整字符串。
    println(s"Result = \n a \n b")
    println(raw"Result = \n a \n b")
  }
}
