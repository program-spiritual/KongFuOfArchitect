public class Employee implements java.io.Serializable {

  public String name;
  //    private String name;
  public String address;
  public int number;
  public transient int SSN;

  public Employee(String name, String address, int number) {
    System.out.println("Constructing an Employee");
    this.name = name;
    this.address = address;
    this.number = number;
  }

  public Employee() {}

  public void mailCheck() {
    System.out.println("Mailing a check to " + this.name + " " + this.address);
  }

  public String toString() {
    return name + " " + address + " " + number;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String newAddress) {
    address = newAddress;
  }

  public int getNumber() {
    return number;
  }
}
