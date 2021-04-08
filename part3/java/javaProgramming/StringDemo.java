public class StringDemo {

  public static void main(String[] args) {
    char[] helloArray = { 'h', 'e', 'l', 'l', 'o', '.' };
    String helloString = new String(helloArray);
    System.out.println(helloString);
    // string length
    String palindrome = "Dot saw I was Tod";
    int len = palindrome.length();
    System.out.println("String Length is : " + len);
    //        format string
    String fs;
    float floatVar = 10.1f;
    int intVar = 10;
    String stringVar = "123213";
    fs =
      String.format(
        "The value of the float variable is " +
        "%f, while the value of the integer " +
        "variable is %d, and the string " +
        "is %s",
        floatVar,
        intVar,
        stringVar
      );
    System.out.println(fs);
  }
}
