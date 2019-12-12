object use_get_or_else {
  def main(args: Array[String]): Unit = {
    val a:Option[Int] = Some(5)
    val b:Option[Int] = None
//    如何在没有值的情况下使用 getOrElse 方法访问值或默认值
    println("a.getOrElse(0): " + a.getOrElse(0) )
    println("b.getOrElse(10): " + b.getOrElse(10) )
  }
}
