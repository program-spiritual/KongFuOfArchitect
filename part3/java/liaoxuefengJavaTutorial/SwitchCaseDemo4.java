public class SwitchCaseDemo4 {

  public static void main(String[] args) {
    //        大多数时候，在switch表达式内部，我们会返回简单的值。
    //
    //        但是，如果需要复杂的语句，我们也可以写很多语句，放到{...}里，然后，用yield返回一个值作为switch语句的返回值：
    String fruit = "orange";
    int opt =
      switch (fruit) {
        case "apple" -> 1;
        case "pear", "mango" -> 2;
        default -> {
          int code = fruit.hashCode();
          yield code; // switch语句返回值
        }
      };
    System.out.println("opt = " + opt);
  }
}
