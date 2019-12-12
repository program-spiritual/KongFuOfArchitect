object create_list {
  def main(args: Array[String]): Unit = {
    // List of Strings
//    val fruit: List[String] = List("apples", "oranges", "pears")
//
//    // List of Integers
//    val nums: List[Int] = List(1, 2, 3, 4)
//
//    // Empty List.
//    val empty: List[Nothing] = List()
//
//    // Two dimensional list
//    val dim: List[List[Int]] =
//      List(
//        List(1, 0, 0),
//        List(0, 1, 0),
//        List(0, 0, 1)
//      )
//    / List of Strings
    val fruit = "apples" :: ("oranges" :: ("pears" :: Nil))

    // List of Integers
    val nums = 1 :: (2 :: (3 :: (4 :: Nil)))
    println(nums)
    // Empty List.
    val empty = Nil

    // Two dimensional list
    val dim = (1 :: (0 :: (0 :: Nil))) ::
      (0 :: (1 :: (0 :: Nil))) ::
      (0 :: (0 :: (1 :: Nil))) :: Nil

    println(dim)
  }
}
