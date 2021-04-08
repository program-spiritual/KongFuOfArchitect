public class CharAndStringDemo7 {

  public static void main(String[] args) {
    String s1 = null; // s1是null
    String s2; // 没有赋初值值，s2也是null
    String s3 = s1; // s3也是null
    String s4 = ""; // s4指向空字符串，不是null
    //        注意要区分空值null和空字符串""，空字符串是一个有效的字符串对象，它不等于null。
  }
}
