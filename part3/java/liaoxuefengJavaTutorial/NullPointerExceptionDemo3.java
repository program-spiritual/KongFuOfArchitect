public class NullPointerExceptionDemo3 {

  /**
   * 如果产生了NullPointerException，例如，调用a.b.c.x()时产生了NullPointerException，原因可能是：
   *
   * a是null；
   * a.b是null；
   * a.b.c是null；
   * 确定到底是哪个对象是null以前只能打印这样的日志：
   *
   * System.out.println(a);
   * System.out.println(a.b);
   * System.out.println(a.b.c);
   *
   * */
  public static void main(String[] args) {
    NullPointerExceptionOfPersonDemo p = new NullPointerExceptionOfPersonDemo();
    System.out.println(p.address.city.toLowerCase());
    //        可以在NullPointerException的详细信息中看到类似... because "<local1>.address.city" is null，意思是city字段为null，这样我们就能快速定位问题所在。
    //
    //这种增强的NullPointerException详细信息是Java 14新增的功能，但默认是关闭的，我们可以给JVM添加一个-XX:+ShowCodeDetailsInExceptionMessages参数启用它：
    //
    //java -XX:+ShowCodeDetailsInExceptionMessages Main.java
  }
}

//从Java 14开始，如果产生了NullPointerException，JVM可以给出详细的信息告诉我们null对象到底是谁。我们来看例子：

class NullPointerExceptionOfPersonDemo {

  String[] name = new String[2];
  NullPointerExceptionOfAddressDemo address = new NullPointerExceptionOfAddressDemo();
}

class NullPointerExceptionOfAddressDemo {

  String city;
  String street;
  String zipcode;
}
