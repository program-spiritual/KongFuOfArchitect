package GenericsAndReflections;

import java.lang.reflect.Array;
import superWildcard.Pair;

public class Main {

  public static void main(String[] args)
    throws IllegalAccessException, InstantiationException {
    //        Java的部分反射API也是泛型。例如：Class<T>就是泛型：

    // compile warning:
    Class clazz = String.class;
    String str = (String) clazz.newInstance();

    // no warning:
    Class<String> clazz2 = String.class;
    String str2 = clazz2.newInstance();

    Pair[] arr = new Pair[2];
    Pair<String>[] ps = (Pair<String>[]) arr;

    System.out.println(ps.getClass() == Pair[].class); // true

    String s1 = (String) arr[0].getFirst();
    String s2 = ps[0].getFirst();
  }

  //    必须借助Class<T>来创建泛型数组：
  <T> T[] createArray(Class<T> cls) {
    return (T[]) Array.newInstance(cls, 5);
  }
}
