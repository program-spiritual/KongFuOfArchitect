object find_max_min_on_set {
  def main(args: Array[String]): Unit = {
    val num = Set(5,6,9,20,30,45)

    // find min and max of the elements
    println( "Min element in Set(5,6,9,20,30,45) : " + num.min )
    println( "Max element in Set(5,6,9,20,30,45) : " + num.max )
  }
}
