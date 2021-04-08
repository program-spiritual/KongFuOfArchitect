public class StringAndEncodeDemo4 {

  public static void main(String[] args) {
    String s = "hello";
    s.replace('l', 'w'); // "hewwo"，所有字符'l'被替换为'w'
    s.replace("ll", "~~"); // "he~~o"，所有子串"ll"被替换为"~~"
    //        正则表达式替换
    String s2 = "A,,B;C ,D";
    s2.replaceAll("[\\,\\;\\s]+", ","); // "A,B,C,D"
  }
}
