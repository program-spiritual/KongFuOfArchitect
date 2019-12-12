object find_max_min_on_iterator {
  def main(args: Array[String]): Unit = {
    val ita = Iterator(20,40,2,50,69, 90)
    val itb = Iterator(20,40,2,50,69, 90)

    println("Maximum valued element " + ita.max )
    println("Minimum valued element " + itb.min )
  }
}
