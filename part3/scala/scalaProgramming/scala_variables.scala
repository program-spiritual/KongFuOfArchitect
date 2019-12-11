object scala_variables {
  def main(args: Array[String]): Unit = {
    //使用var关键字定义变量
    var myVar: String = "Foo"
    //  不能更改的变量
    val myVal: String = "Foo"
    //  类型推断
    //  val myVar1: Nothing = 10
    //  val myVal1: Nothing = "Hello, Scala!"
    //  解构
    val (myVar1: Int, myVar2: String) = Pair(40, "Foo")
    println(myVar);
    println(myVal);
    println(myVar1);
//    println(myVal1);
  }


}
