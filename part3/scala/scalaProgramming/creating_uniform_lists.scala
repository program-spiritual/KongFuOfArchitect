object creating_uniform_lists {
  def main(args: Array[String]): Unit = {
    val fruit = List.fill(3)("apples") // Repeats apples three times.
    println( "fruit : " + fruit  )

    val num = List.fill(10)(2)         // Repeats 2, 10 times.
    println( "num : " + num  )
  }
}
