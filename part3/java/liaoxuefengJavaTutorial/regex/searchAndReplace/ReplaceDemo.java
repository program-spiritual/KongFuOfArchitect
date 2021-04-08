package regex.searchAndReplace;

public class ReplaceDemo {

  public static void main(String[] args) {
    String s = "The     quick\t\t brown   fox  jumps   over the  lazy dog.";
    String r = s.replaceAll("\\s+", " ");
    System.out.println(r); // "The quick brown fox jumps over the lazy dog."
  }
}
