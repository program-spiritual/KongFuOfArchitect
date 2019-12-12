object converting_to_string {
  def main(args: Array[String]): Unit = {
    val t = new Tuple3(1, "hello", Console)

    println("Concatenated String: " + t.toString() )
  }
}
