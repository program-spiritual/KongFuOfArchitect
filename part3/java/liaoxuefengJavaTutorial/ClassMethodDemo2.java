public class ClassMethodDemo2 {

  private String name;

  //在方法内部，可以使用一个隐含的变量this，它始终指向当前实例。因此，通过this.field就可以访问当前实例的字段。
  //
  //如果没有命名冲突，可以省略this。例如：
  public String getName() {
    return name; // 相当于this.name
  }

  //    但是，如果有局部变量和字段重名，那么局部变量优先级更高，就必须加上this
  public void setName(String name) {
    this.name = name; // 前面的this不可少，少了就变成局部变量name了
  }

  public static void main(String[] args) {}
}
