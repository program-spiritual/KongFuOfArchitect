public class PackagingTypeDemo1 {
    public static void main(String[] args) {
        Integer x = 127;
        Integer y = 127;
        Integer m = 99999;
        Integer n = 99999;
        System.out.println("x == y: " + (x==y)); // true
        System.out.println("m == n: " + (m==n)); // false
        System.out.println("x.equals(y): " + x.equals(y)); // true
        System.out.println("m.equals(n): " + m.equals(n)); // true

//        仔细观察结果的童鞋可以发现，==比较，较小的两个相同的Integer返回true，较大的两个相同的Integer返回false，
//       这是因为Integer是不变类，编译器把Integer x = 127;自动变为Integer x = Integer.valueOf(127);，
//      为了节省内存，Integer.valueOf()对于较小的数，始终返回相同的实例，
//     因此，==比较“恰好”为true，但我们绝不能因为Java标准库的Integer内部有缓存优化就用==比较，必须用equals()方法比较两个Integer

//        因为Integer.valueOf()可能始终返回同一个Integer实例，因此，在我们自己创建Integer的时候，以下两种方法：
//
//        方法1：Integer n = new Integer(100);
//        方法2：Integer n = Integer.valueOf(100);
//        方法2更好，因为方法1总是创建新的Integer实例，方法2把内部优化留给Integer的实现者去做，即使在当前版本没有优化，也有可能在下一个版本进行优化。
//
//        我们把能创建“新”对象的静态方法称为静态工厂方法。Integer.valueOf()就是静态工厂方法，它尽可能地返回缓存的实例以节省内存。
    }
}
//因此，一旦创建了Integer对象，该对象就是不变的。
//
//        对两个Integer实例进行比较要特别注意：绝对不能用==比较，因为Integer是引用类型，必须使用equals()比较：

final class Integer3 {
    private final int value;

    public Integer3(int value) {
        this.value = value;
    }
}