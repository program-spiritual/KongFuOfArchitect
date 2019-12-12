object pattern_matching_with_extractors {
  def main(args: Array[String]): Unit = {
    val x = pattern_matching_with_extractors(5)
    println(x)

    x match {
      case pattern_matching_with_extractors(num) => println(x+" is bigger two times than "+num)

      //unapply is invoked
      case _ => println("i cannot calculate")
    }
  }
  def apply(x: Int) = x*2
  def unapply(z: Int): Option[Int] = if (z%2==0) Some(z/2) else None
}
