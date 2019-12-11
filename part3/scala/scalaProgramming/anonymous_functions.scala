object anonymous_functions {
  def main(args: Array[String]): Unit = {
    var inc = (x:Int) => x+1
    var x = inc(7)-1
    var mul = (x: Int, y: Int) => x*y
    println(mul(3, 4))
//    也可以如下定义不带参数的函数：
    var userDir = () => { System.getProperty("user.dir") }
    println( userDir )
  }
}
