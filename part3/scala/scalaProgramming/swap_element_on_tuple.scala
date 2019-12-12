object swap_element_on_tuple {
  def main(args: Array[String]): Unit = {
//    您可以使用Tuple.swap方法交换Tuple2的元素。
    val t = new Tuple2("Scala", "hello")

    println("Swapped Tuple: " + t.swap )
  }
}
