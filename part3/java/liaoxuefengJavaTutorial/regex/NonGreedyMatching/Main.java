package regex.NonGreedyMatching;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 因此，给定一个匹配规则，加上?后就变成了非贪婪匹配。
 *
 * 我们再来看这个正则表达式(\d??)(9*)，注意\d?表示匹配0个或1个数字，后面第二个?表示非贪婪匹配，
 * 因此，给定字符串"9999"，匹配到的两个子串分别是""和"9999"，因为对于\d?来说，可以匹配1个9，也可以匹配0个9，
 * 但是因为后面的?表示非贪婪匹配，它就会尽可能少的匹配，结果是匹配了0个9。
 *
 * 小结
 * */
public class Main {

  public static void main(String[] args) {
    //        Pattern pattern = Pattern.compile("(\\d+)(0*)");
    Pattern pattern = Pattern.compile("(\\d+?)(0*)");
    Matcher matcher = pattern.matcher("1230000");
    if (matcher.matches()) {
      System.out.println("group1=" + matcher.group(1)); // "1230000"
      System.out.println("group2=" + matcher.group(2)); // ""
    }

    Pattern p2 = Pattern.compile("(\\d??)(9*)");
    Matcher matcher2 = p2.matcher("9999");
    if (matcher2.matches()) {
      System.out.println("group1=" + matcher2.group(1));
      System.out.println("group2=" + matcher2.group(2));
    }
  }
}
