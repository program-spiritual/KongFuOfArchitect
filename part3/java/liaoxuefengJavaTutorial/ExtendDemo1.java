public class ExtendDemo1 {
    public static void main(String[] args) {

    }
}
//继承是面向对象编程中非常强大的一种机制，它首先可以复用代码。当我们让Student从Person继承时，Student就获得了Person的所有功能，我们只需要为Student编写新增的功能。
//
//Java使用extends关键字来实现继承：
//在OOP的术语中，我们把Person称为超类（super class），父类（parent class），基类（base class），把Student称为子类（subclass），扩展类（extended class）。
//
//继承树
//注意到我们在定义Person的时候，没有写extends。
//在Java中，没有明确写extends的类，编译器会自动加上extends Object。
//所以，任何类，除了Object，都会继承自某个类。下图是Person、Student的继承树：
//┌───────────┐
//│  Object   │
//└───────────┘
//      ▲
//      │
//┌───────────┐
//│  Person   │
//└───────────┘
//      ▲
//      │
//┌───────────┐
//│  Student  │
//└───────────┘
//Java只允许一个class继承自一个类，因此，一个类有且仅有一个父类。只有Object特殊，它没有父类。
//
//类似的，如果我们定义一个继承自Person的Teacher，它们的继承树关系如下：
//
//       ┌───────────┐
//       │  Object   │
//       └───────────┘
//             ▲
//             │
//       ┌───────────┐
//       │  Person   │
//       └───────────┘
//          ▲     ▲
//          │     │
//          │     │
//┌───────────┐ ┌───────────┐
//│  Student  │ │  Teacher  │
//└───────────┘ └───────────┘
class Person9 extends Object {

}