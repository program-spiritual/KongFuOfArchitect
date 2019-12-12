object use_iterator_with_while_loop {
  def main(args: Array[String]): Unit = {
    val it = Iterator("a", "number", "of", "words")

    while (it.hasNext){
      println(it.next())
    }
  }
}
