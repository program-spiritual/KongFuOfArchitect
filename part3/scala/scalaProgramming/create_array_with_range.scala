import Array._

object create_array_with_range {
  def main(args: Array[String]): Unit = {
    var myList1 = range(10, 20, 2)
    var myList2 = range(10,20)

    // Print all the array elements
    for ( x <- myList1 ) {
      print( " " + x )
    }

    println()
    for ( x <- myList2 ) {
      print( " " + x )
    }
  }
}
