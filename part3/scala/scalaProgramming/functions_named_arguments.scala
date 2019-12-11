object functions_named_arguments {
  def main(args: Array[String]): Unit = {
    printInt(a=5,b=7)
  }
  def printInt(a:Int,b:Int): Unit ={
    println("Value of a : " + a)
    println("Value of b : " + b)
  }
}
