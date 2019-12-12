object size_len_on_iterator {
  def main(args: Array[String]): Unit = {
    val ita = Iterator(20,40,2,50,69, 90)
    val itb = Iterator(20,40,2,50,69, 90)

    println("Value of ita.size : " + ita.size )
    println("Value of itb.length : " + itb.length )
  }
}
