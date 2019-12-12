object create_a_tuple {
  def main(args: Array[String]): Unit = {
//    元组的类型为Tuple1，Tuple2，Tuple3等。如果需要更多，Scala当前上限为22
//    Scala当前上限为22，则可以使用集合而不是元组。对于每个TupleN类型，其中1 <= N <= 22
    val t = new Tuple3(1, "hello", Console)

  }
}
