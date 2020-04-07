public class ConstDemo {
    public static void main(String[] args) {
//        定义变量的时候，如果加上final修饰符，这个变量就变成了常量
//        常量在定义时进行初始化后就不可再次赋值，再次赋值会导致编译错误
//        常量的作用是用有意义的变量名来避免魔术数字（Magic number），例如，不要在代码中到处写3.14，而是定义一个常量。如果将来需要提高计算精度，我们只需要在常量的定义处修改，例如，改成3.1416，而不必在所有地方替换3.14。
        final double PI = 3.14; // PI是一个常量
        double r = 5.0;
        double area = PI * r * r;
//        PI = 300; // compile error! Error:(6, 9) java: 无法为最终变量PI分配值
    }
}
