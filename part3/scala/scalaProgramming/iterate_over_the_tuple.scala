object iterate_over_the_tuple {
  def main(args: Array[String]): Unit = {
    val t = (4,3,2,1)

    t.productIterator.foreach{ i =>println("Value = " + i )}
  }
}
