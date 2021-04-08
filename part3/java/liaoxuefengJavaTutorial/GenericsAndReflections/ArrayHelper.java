package GenericsAndReflections;

public class ArrayHelper {

  //    我们还可以利用可变参数创建泛型数组T[]：
  @SafeVarargs
  static <T> T[] asArray(T... objs) {
    return objs;
  }

  public static void main(String[] args) {
    String[] ss = ArrayHelper.asArray("a", "b", "c");
    Integer[] ns = ArrayHelper.asArray(1, 2, 3);
  }
}
