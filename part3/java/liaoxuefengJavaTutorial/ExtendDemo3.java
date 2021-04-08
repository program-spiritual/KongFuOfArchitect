public class ExtendDemo3 {

  public static void main(String[] args) {
    //如果一个引用变量的类型是Student，那么它可以指向一个Student类型的实例：
    Student s = new Student();
    //        如果一个引用类型的变量是Person，那么它可以指向一个Person类型的实例：
    Person10 p = new Student(); // ???
    //        测试一下就可以发现，这种指向是允许的！
    //
    //这是因为Student继承自Person，因此，它拥有Person的全部功能。Person类型的变量，如果指向Student类型的实例，对它进行操作，是没有问题的！
    //        这种把一个子类类型安全地变为父类类型的赋值，被称为向上转型（upcasting）
    //        注意到继承树是Student > Person > Object，所以，可以把Student类型转型为Person，或者更高层次的Object。
  }
}
