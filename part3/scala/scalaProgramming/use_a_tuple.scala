object use_a_tuple {
  def main(args: Array[String]): Unit = {
    val t = (4,3,2,1)
    val sum = t._1 + t._2 + t._3 + t._4
    println( "Sum of elements: "  + sum )
  }
}
