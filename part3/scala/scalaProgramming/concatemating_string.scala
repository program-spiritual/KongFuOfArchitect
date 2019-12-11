object concatemating_string {
  def main(args: Array[String]): Unit = {
    var string1 = "hi "
    var string2= "siri"
    var string3 = string1.concat(string2)
    println(string3)

    val str1 = "Dot saw I was "
    val str2 = "Tod"

    println("Dot " + str1 + str2)
  }
}
