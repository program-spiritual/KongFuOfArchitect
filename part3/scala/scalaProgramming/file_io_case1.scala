import java.io._
object file_io_case1 {
  def main(args: Array[String]): Unit = {
    val writer = new PrintWriter(new File("test.txt" ))

    writer.write("Hello Scala")
    writer.close()
  }
}
