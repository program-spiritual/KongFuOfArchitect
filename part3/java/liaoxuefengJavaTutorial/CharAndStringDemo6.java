public class CharAndStringDemo6 {

  /***
   * 观察执行结果，难道字符串s变了吗？其实变的不是字符串，而是变量s的“指向”。
   *
   * 执行String s = "hello";时，JVM虚拟机先创建字符串"hello"，然后，把字符串变量s指向它：
   *
   *       s
   *       │
   *       ▼
   * ┌───┬───────────┬───┐
   * │   │  "hello"  │   │
   * └───┴───────────┴───┘
   * 紧接着，执行s = "world";时，JVM虚拟机先创建字符串"world"，然后，把字符串变量s指向它：
   *
   *       s ──────────────┐
   *                       │
   *                       ▼
   * ┌───┬───────────┬───┬───────────┬───┐
   * │   │  "hello"  │   │  "world"  │   │
   * └───┴───────────┴───┴───────────┴───┘
   * 原来的字符串"hello"还在，只是我们无法通过变量s访问它而已。因此，字符串的不可变是指字符串内容不可变。
   * */
  public static void main(String[] args) {
    String s = "hello";
    System.out.println(s); // 显示 hello
    s = "world";
    System.out.println(s); // 显示 world

    String s2 = "hello";
    String t = s2;
    s2 = "world";
    System.out.println(t); // t是"hello"还是"world"?
  }
}
