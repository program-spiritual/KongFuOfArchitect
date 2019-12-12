import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException

object catch_exception1 {
  def main(args: Array[String]) {
    try {
      val f = new FileReader("input.txt")
    } catch {
      case ex: FileNotFoundException =>{
        println("Missing file exception")
      }

      case ex: IOException => {
        println("IO Exception")
      }
    }
  }
}