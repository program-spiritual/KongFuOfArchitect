object reading_from_command_line {
  def main(args: Array[String]): Unit = {
    print("Please enter your input : " )
    val line = Console.readLine

    println("Thanks, you just typed: " + line)
  }
}
