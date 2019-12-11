object for_loop_to {
  def main(args: Array[String]): Unit = {
    var a = 0;

    // for loop execution with a range
    for( a <- 1 to 10){
      println( "Value of a: " + a );
    }
  }
}
