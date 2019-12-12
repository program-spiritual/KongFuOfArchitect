import scala.io.Source
object reading_file_content {
  def main(args: Array[String]): Unit = {
    println("Following is the content read:" )

    Source.fromFile("test.txt" ).foreach {
      print
    }
  }
}
