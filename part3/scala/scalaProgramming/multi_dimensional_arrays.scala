import Array._
object multi_dimensional_arrays {
  def main(args: Array[String]): Unit = {
    var myMatrix = ofDim[Int](3,3)
    print(myMatrix)
//矩阵和表格是可以实现为二维数组的结构示例。
    // build a matrix
    for (i <- 0 to 2) {
      for ( j <- 0 to 2) {
        myMatrix(i)(j) = j;
      }
    }

    // Print two dimensional array
    for (i <- 0 to 2) {
      for ( j <- 0 to 2) {
        print(" " + myMatrix(i)(j));
      }
      println();
    }
  }
}
