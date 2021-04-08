public class WipingMethodDemo1 {

  public static void main(String[] args)
    throws InstantiationException, IllegalAccessException {
    // 局限1 T 不能是基本类型
    //        Pair<int> p = new Pair<>(1, 2); // compile error!
    // 局限2       无法取得带泛型的Class。观察以下代码：
    Pair<String> p1 = new Pair<>("Hello", "world");
    Pair<Integer> p2 = new Pair<>(123, 456);
    Class c1 = p1.getClass();
    Class c2 = p2.getClass();
    System.out.println(c1 == c2); // true
    System.out.println(c1 == Pair.class); // true
    //        因为T是Object，我们对Pair<String>和Pair<Integer>类型获取Class时，获取到的是同一个Class，也就是Pair类的Class。
    //
    //换句话说，所有泛型实例，无论T的类型是什么，getClass()返回同一个Class实例，因为编译后它们全部都是Pair<Object>。
    //        局限三：无法判断带泛型的Class：
    Pair<Integer> p = new Pair<>(123, 456);
    // Compile error:
    //        if (p instanceof Pair<String>.class) {
    //        }
    //        不能实例化T类型：
    //        要实例化T类型，我们必须借助额外的Class<T>参数：
    Pair<String> pair = new Pair<>(String.class);
  }
}
//因此，Java使用擦拭法实现泛型，导致了：
//
//编译器把类型<T>视为Object；
//编译器根据<T>实现安全的强制转型。
//Java的泛型是由编译器在编译时实行的，
//编译器内部永远把所有类型T视为Object处理，
//但是，在需要转型的时候，编译器会根据T的类型自动为我们实行安全地强制转型。
