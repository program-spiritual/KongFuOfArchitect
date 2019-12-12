import scala.util.matching.Regex
object use_regular_expressions {
  def main(args: Array[String]): Unit = {
//    要查找正则表达式的第一个匹配项，只需调用 findFirstIn 方法。
//    如果我们想查找匹配单词的所有匹配项，而不是仅查找第一个匹配项，可以使用 findAllIn 方法.
//    如果目标字符串中有多个 Scala 单词可用，这将返回所有匹配单词的集合。
//    您可以使用 mkString 方法来连接结果列表，
//   并且可以使用管道（|）搜索 Scala 的小写大写字母，还可以使用 Regex 构造函数或 r 方法来创建模式。
    val pattern = new Regex("(S|s)cala")
    val str = "Scala is scalable and cool"

    println((pattern findAllIn str).mkString(","))
  }
}
