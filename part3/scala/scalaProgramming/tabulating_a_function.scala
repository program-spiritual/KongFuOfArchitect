object tabulating_a_function {
  def main(args: Array[String]): Unit = {
//    您可以将函数与 List.tabulate 方法一起使用，以在对列表进行制表之前将其应用于列表的所有元素。
// Creates 5 elements using the given function.
//    第一个参数列表提供要创建的列表的尺寸，第二个参数描述列表的元素。
//    它们不是固定的元素而是从函数中计算出来的。
val squares = List.tabulate(6)(n => n * n)
    println( "squares : " + squares  )

    val mul = List.tabulate( 4,5 )( _ * _ )
    println( "mul : " + mul  )
  }
}
