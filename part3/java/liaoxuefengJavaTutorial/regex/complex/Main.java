package regex.complex;

public class Main {

  public static void main(String[] args) {
    String re = "java|php";
    System.out.println("java".matches(re));
    System.out.println("php".matches(re));
    System.out.println("go".matches(re));

    String re2 = "learn\\s(java|php|go)";
    System.out.println("learn java".matches(re2));
    System.out.println("learn Java".matches(re2));
    System.out.println("learn php".matches(re2));
    System.out.println("learn Go".matches(re2));
  }
}
