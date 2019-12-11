object for_loop_with_collection {
  def main(args: Array[String]): Unit = {
    var a = 0;
    val numList = List(1,2,3,4,5,6);

    // for loop execution with a collection
    for( a <- numList ){
      println( "Value of a: " + a );
    }
  }
}
