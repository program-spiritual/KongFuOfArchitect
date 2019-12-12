object reverse_list_order {
  def main(args: Array[String]): Unit = {
    val fruit = "apples" :: ("oranges" :: ("pears" :: Nil))

    println( "Before reverse fruit : " + fruit )
    println( "After reverse fruit : " + fruit.reverse )
  }
}
