object creating_array {
  def main(args: Array[String]): Unit = {
    var z = new Array[String](3)
    z(0) = "Zara"
    z(1) = "Nuha"
    z(4/2) = "Ayan"
    println(z)
  }
}
