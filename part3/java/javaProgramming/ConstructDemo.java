public class ConstructDemo {

  public ConstructDemo() {}

  public static void main(String[] args) {
    noParamConstructDemo t1 = new noParamConstructDemo();
    noParamConstructDemo t2 = new noParamConstructDemo();
    System.out.println(t1.num + " " + t2.num);
  }
}
