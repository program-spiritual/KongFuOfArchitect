public class StringAndEncodeDemo6 {

  public static void main(String[] args) {
    String[] arr = { "A", "B", "C" };
    //        拼接字符串使用静态方法join()，它用指定的字符串连接字符串数组：
    String s = String.join("***", arr); // "A***B***C"
  }
}
