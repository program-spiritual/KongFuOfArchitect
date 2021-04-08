package regex.searchAndReplace;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchDemo {

  public static void main(String[] args) {
    String s = "the quick brown fox jumps over the lazy dog.";
    Pattern p = Pattern.compile("\\wo\\w");
    Matcher m = p.matcher(s);
    while (m.find()) {
      String sub = s.substring(m.start(), m.end());
      System.out.println(sub);
    }
  }
}
