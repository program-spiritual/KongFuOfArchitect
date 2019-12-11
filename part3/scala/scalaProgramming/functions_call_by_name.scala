object functions_call_by_name {
//  每次调用该参数时候 都会首先计算值
  def main(args: Array[String]): Unit = {
    delayed(time())
  }
  def time() = {
    println("Getting time in nano seconds")
    System.nanoTime
  }
  def delayed( t: => Long ) = {
    println("In delayed method")
    println("Param: " + t)
  }
}
