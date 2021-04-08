public class CharAndStringDemo3 {

  /**
   * 常见的转义字符包括：
   *
   * \" 表示字符"
   * \' 表示字符'
   * \\ 表示字符\
   * \n 表示换行符
   * \r 表示回车符
   * \t 表示Tab
   * \\u#### 表示一个Unicode编码的字符
   * */
  public static void main(String[] args) {
    String s = ""; // 空字符串，包含0个字符
    String s1 = "A"; // 包含一个字符
    String s2 = "ABC"; // 包含3个字符
    String s3 = "中文 ABC"; // 包含6个字符，其中有一个空格
    //        字符串使用双引号"..."表示开始和结束，那如果字符串本身恰好包含一个"字符怎么表示？
    //       例如，"abc"xyz"，编译器就无法判断中间的引号究竟是字符串的一部分还是表示字符串结束。
    //      这个时候，我们需要借助转义字符\：
    String a = "ABC\n\u4e2d\u6587"; // 包含6个字符: A, B, C, 换行符, 中, 文
  }
}
