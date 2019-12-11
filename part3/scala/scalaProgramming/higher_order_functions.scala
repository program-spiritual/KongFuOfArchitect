object higher_order_functions {
  def main(args: Array[String]): Unit = {
    println( apply( layout, 10) )
  }
  def apply(f: Int => String, v: Int) = f(v)

  def layout[A](x: A) = "[" + x.toString() + "]"
}
