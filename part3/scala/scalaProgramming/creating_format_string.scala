object creating_format_string {
  def main(args: Array[String]): Unit = {
    var floatVar = 12.456
    var intVar = 2000
    var stringVar = "Hello, Scala!"

    var fs = printf("The value of the float variable is " + "%f, while the value of the integer " + "variable is %d, and the string" + "is %s", floatVar, intVar, stringVar);

    println(fs)
  }
}
