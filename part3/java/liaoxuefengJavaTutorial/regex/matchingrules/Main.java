package regex.matchingrules;

public class Main {

  /**
   * 正则表达式的匹配规则是从左到右按规则匹配。我们首先来看如何使用正则表达式来做精确匹配。
   *
   * 对于正则表达式abc来说，它只能精确地匹配字符串"abc"，不能匹配"ab"，"Abc"，"abcd"等其他任何字符串。
   *如果正则表达式有特殊字符，那就需要用\转义。例如，正则表达式a\&c，
   * 其中\&是用来匹配特殊字符&的，它能精确匹配字符串"a&c"，但不能匹配"ac"、"a-c"、"a&&c"等。
   * 要注意正则表达式在Java代码中也是一个字符串，所以，对于正则表达式a\&c来说，
   * 对应的Java字符串是"a\\&c"，因为\也是Java字符串的转义字符，两个\\实际上表示的是一个\：
   * */
  public static void main(String[] args) {
    String re1 = "abc";
    System.out.println("abc".matches(re1));
    System.out.println("Abc".matches(re1));
    System.out.println("abcd".matches(re1));

    String re2 = "a\\&c"; // 对应的正则是a\&c
    System.out.println("a&c".matches(re2));
    System.out.println("a-c".matches(re2));
    System.out.println("a&&c".matches(re2));
  }
}
