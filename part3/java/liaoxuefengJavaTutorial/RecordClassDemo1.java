public class RecordClassDemo1 {
    public static void main(String[] args) {
//        为了保证不变类的比较，还需要正确覆写equals()和hashCode()方法，这样才能在集合类中正常使用。后续我们会详细讲解正确覆写equals()和hashCode()，这里演示Point不变类的写法目的是，这些代码写起来都非常简单，但是很繁琐。
        var z = PointDemo2.of();
        var p = PointDemo2.of(123, 456);
        System.out.println(z);
        System.out.println(p);
    }
}


//假设我们希望定义一个Point类，有x、y两个变量，同时它是一个不变类，可以这么写：
final class PointDemo1 {
    private final int x;
    private final int y;

    public PointDemo1(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return this.x;
    }

    public int y() {
        return this.y;
    }
}

//从Java 14开始，引入了新的Record类。我们定义Record类时，使用关键字record。把上述Point类改写为Record类，代码如下：
//仔细观察Point的定义：
//
//public record Point(int x, int y) {}
record PointDemo2(int x, int y) {
    //    编译器默认按照record声明的变量顺序自动创建一个构造方法，并在方法内给字段赋值。那么问题来了，如果我们要检查参数，应该怎么办？
//
//假设Point类的x、y不允许负数，我们就得给Point的构造方法加上检查逻辑：
//    注意到方法public Point {...}被称为Compact Constructor，它的目的是让我们编写检查逻辑：
    public PointDemo2 {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException();
        }
    }

    //    作为record的Point仍然可以添加静态方法。一种常用的静态方法是of()方法，用来创建Point：
    public static PointDemo2 of() {
        return new PointDemo2(0, 0);
    }

    public static PointDemo2 of(int x, int y) {
        return new PointDemo2(x, y);
    }
}

// 改写为 class

// final  class PointDemo3 extends Record {
//     private final int x;
//     private final int y;
//
//     public PointDemo3(int x, int y) {
//         this.x = x;
//         this.y = y;
//     }
//
//     public int x() {
//         return this.x;
//     }
//
//     public int y() {
//         return this.y;
//     }
//
//     public String toString() {
//         return String.format("Point[x=%s, y=%s]", x, y);
//     }
//
//     @Override
//     public boolean equals(Object obj) {
//         return false;
//     }
//
//     @Override
//     public int hashCode() {
//         return 0;
//     }
// }