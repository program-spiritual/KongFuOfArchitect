import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class WipingMethodDemo2 extends Pair<Integer> {

  public WipingMethodDemo2(Integer first, Integer last) {
    super(first, last);
  }

  public WipingMethodDemo2(Class<Integer> clazz)
    throws IllegalAccessException, InstantiationException {
    super(clazz);
  }

  public static void main(String[] args) {
    //        使用的时候，因为子类IntPair并没有泛型类型，所以，正常使用即可：

    WipingMethodDemo2 ip = new WipingMethodDemo2(1, 2);

    //        在继承了泛型类型的情况下，子类可以获取父类的泛型类型。例如：IntPair可以获取到父类的泛型类型Integer。获取父类的泛型类型代码比较复杂
    Class<WipingMethodDemo2> clazz = WipingMethodDemo2.class;
    Type t = clazz.getGenericSuperclass();
    if (t instanceof ParameterizedType) {
      ParameterizedType pt = (ParameterizedType) t;
      Type[] types = pt.getActualTypeArguments(); // 可能有多个泛型类型
      Type firstType = types[0]; // 取第一个泛型类型
      Class<?> typeClass = (Class<?>) firstType;
      System.out.println(typeClass); // Integer
      /***
       * 因为Java引入了泛型，所以，只用Class来标识类型已经不够了。实际上，Java的类型系统结构如下：
       *
       *                       ┌────┐
       *                       │Type│
       *                       └────┘
       *                          ▲
       *                          │
       *    ┌────────────┬────────┴─────────┬───────────────┐
       *    │            │                  │               │
       * ┌─────┐┌─────────────────┐┌────────────────┐┌────────────┐
       * │Class││ParameterizedType││GenericArrayType││WildcardType│
       * └─────┘└─────────────────┘└────────────────┘└────────────┘
       *
       * */
    }
  }
}
