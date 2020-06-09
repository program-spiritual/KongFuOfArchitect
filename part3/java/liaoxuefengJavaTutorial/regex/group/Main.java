package regex.group;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("(\\d{3,4})\\-(\\d{7,8})");
        Matcher m = p.matcher("010-12345678");
        if (m.matches()) {
            String g1 = m.group(1);
            String g2 = m.group(2);
            System.out.println(g1);
            System.out.println(g2);
        } else {
            System.out.println("匹配失败!");
        }

        /**
         * 要特别注意，Matcher.group(index)方法的参数用1表示第一个子串，2表示第二个子串。
         * 如果我们传入0会得到什么呢？答案是010-12345678，即整个正则匹配到的字符串。
         * */
    }
}
