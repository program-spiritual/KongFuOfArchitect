package hello;

//Main类也定义在hello包下面：
public class Main {

  public static void main(String[] args) {
    Person p = new Person();
    p.hello(); // 可以调用，因为Main和Person在同一个包
  }
}
