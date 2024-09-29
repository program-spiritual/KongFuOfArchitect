package builder;

class User{
  private String name;
  private int age;
  private String address;
  private  User(String name, int age, String address) {
    this.name = name;
    this.age = age;
    this.address = address;
  }
  // static public class UserBuilder 
  public static UserBuilder builder() {
    return new UserBuilder();
  }

  public static class UserBuilder {
    private String name;
    private int age;
    private String address;

    private UserBuilder() {  
    } 

    public UserBuilder name(String name) {
      this.name = name;
      return this;
    }
    public UserBuilder age(int age) {
      this.age = age;
      return this;
    }
    public UserBuilder address(String address) {
      this.address = address;
      return this;
    }
    public User build() {
      if (name == null) {
        throw new IllegalStateException("name is required");
      }
      if (age == 0) {
        throw new IllegalStateException("age is required");
      }
      if (address == null) {
        throw new IllegalStateException("address is required");
      }
      return new User(name, age, address);
    }
  }
}