package regex.notNumber;

public class Main {

  public static void main(String[] args) {
    String re1 = "java\\d"; // 对应的正则是java\d
    System.out.println("java9".matches(re1));
    System.out.println("java10".matches(re1));
    System.out.println("javac".matches(re1));

    String re2 = "java\\D";
    System.out.println("javax".matches(re2));
    System.out.println("java#".matches(re2));
    System.out.println("java5".matches(re2));
  }
}
