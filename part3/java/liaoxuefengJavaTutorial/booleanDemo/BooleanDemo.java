package booleanDemo;

public class BooleanDemo {

  public BooleanDemo() {}

  //，因为理论上存储布尔类型只需要1 bit，但是通常JVM内部会把boolean表示为4字节整数
  public static void main(String[] args) {
    boolean b1 = true;
    boolean b2 = false;
    boolean isGreater = 5 > 3; // 计算结果为true
    int age = 12;
    boolean isAdult = age >= 18; // 计算结果为false
  }
}
