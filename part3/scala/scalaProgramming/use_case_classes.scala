object use_case_classes {
//  案例类是特殊的类，用于与案例表达式进行模式匹配。从语法上讲，这些是带有特殊修饰符的标准类：case。
//  添加case关键字会使编译器自动添加许多有用的功能。关键字建议在模式匹配中与大小写表达式相关联。
//  首先，编译器自动将构造函数参数转换为不可变的字段（值）。
// val关键字是可选的。如果要使用可变字段，请使用var关键字。因此，我们的构造函数参数列表现在更短了
//  其次，编译器自动对类实现 equals，hashCode 和 toString 方法，
// 这些方法使用指定为构造函数参数的字段。
//因此，我们不再需要我们自己的 toString 方法
  case class Person(name: String, age: Int)
  def main(args: Array[String]): Unit = {
    val alice = new Person("Alice", 25)
    val bob = new Person("Bob", 32)
    val charlie = new Person("Charlie", 32)

    for (person <- List(alice, bob, charlie)) {
      person match {
        case Person("Alice", 25) => println("Hi Alice!")
        case Person("Bob", 32) => println("Hi Bob!")
        case Person(name, age) => println(
          "Age: " + age + " year, name: " + name + "?")
      }
    }
  }
}
