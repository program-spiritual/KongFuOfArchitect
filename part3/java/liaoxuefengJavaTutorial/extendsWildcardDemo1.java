public class extendsWildcardDemo1 {

  public static void main(String[] args) {
    int sum = PairHelper.add(new Pair<Number>(1, 2));
    Pair<Integer> p = new Pair<>(123, 456);
    int n = add(p); // Error:(5, 21) java: 不兼容的类型: Pair<java.lang.Integer>无法转换为Pair<java.lang.Number>
    //        原因很明显，因为Pair<Integer>不是Pair<Number>的子类，因此，add(Pair<Number>)不接受参数类型Pair<Integer>。
    System.out.println(n);
  }

  //    static int add(Pair<Number> p) {
  //有没有办法使得方法参数接受Pair<Integer>？办法是有的，
  //这就是使用Pair<? extends Number>使得方法接收所有泛型类型为Number或Number子类的Pair类型。
  //我们把代码改写如下：使用<? extends Number>的泛型定义称之为上界通配符（Upper Bounds Wildcards），即把泛型类型T的上界限定在Number了。
  // 除了可以传入Pair<Integer>类型，我们还可以传入Pair<Double>类型，
  //Pair<BigDecimal>类型等等，因为Double和BigDecimal都是Number的子类。

  static int add(Pair<? extends Number> p) {
    Number first = p.getFirst();
    Number last = p.getLast();
    return first.intValue() + last.intValue();
  }
}

class PairHelper {

  static int add(Pair<Number> p) {
    Number first = p.getFirst();
    Number last = p.getLast();
    return first.intValue() + last.intValue();
  }
}
