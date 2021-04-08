public class ClassBasicDemo2 {

  public static void main(String[] args) {
    City bj = new City();
    bj.name = "Beijing";
    bj.latitude = 39.903;
    bj.longitude = 116.401;
    System.out.println(bj.name);
    System.out.println("location: " + bj.latitude + ", " + bj.longitude);
  }
}

class City {

  public String name;
  public double latitude;
  public double longitude;
}
