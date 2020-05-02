import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

import java.lang.reflect.Field;

@interface Range2{
    int min() default 0;
    int max() default 10;
}

public class HandleAnnotationDemo1  {
    @Range2(min=1, max=20)
    public String name;

    @Range2(max=10)
    public String city;
    public static void main(String[] args) throws Exception {
// 判断@Report是否存在于Person类:
      boolean exist =   Person.class.isAnnotationPresent(Report.class);
      System.out.println(exist);
      /**
       * 使用反射API读取Annotation：
       *
       * Class.getAnnotation(Class)
       * Field.getAnnotation(Class)
       * Method.getAnnotation(Class)
       * Constructor.getAnnotation(Class)
       * */
        // 获取Person定义的@Report注解:
        Report report = Person.class.getAnnotation(Report.class);
        int type = report.type();
        String level = report.level();
//        使用反射API读取Annotation有两种方法。方法一是先判断Annotation是否存在，如果存在，就直接读取：
        Class cls = Person.class;
        if (cls.isAnnotationPresent(Report.class)) {
            Report report2 = (Report) cls.getAnnotation(Report.class);
//    ...
        }

//        读取方法、字段和构造方法的Annotation和Class类似。
//       但要读取方法参数的Annotation就比较麻烦一点，
//      因为方法参数本身可以看成一个数组，而每个参数又可以定义多个注解，
//     所以，一次获取方法参数的所有注解就必须用一个二维数组来表示。
//    例如，对于以下方法定义的注解：

    }

//    public void hello(@NotNull @Range(max=5) String name, @NotNull String prefix) {
//    }

    void check(Person person) throws IllegalArgumentException, ReflectiveOperationException {
        // 遍历所有Field:
        for (Field field : person.getClass().getFields()) {
            // 获取Field定义的@Range:
            Range2 range = field.getAnnotation(Range2.class);
            // 如果@Range存在:
            if (range != null) {
                // 获取Field的值:
                Object value = field.get(person);
                // 如果值是String:
                if (value instanceof String) {
                    String s = (String) value;
                    // 判断值是否满足@Range的min/max:
                    if (s.length() < range.min() || s.length() > range.max()) {
                        throw new IllegalArgumentException("Invalid field: " + field.getName());
                    }
                }
            }
        }
    }

//    这样一来，我们通过@Range注解，配合check()方法，就可以完成Person实例的检查。注意检查逻辑完全是我们自己编写的，JVM不会自动给注解添加任何额外的逻辑
}
/**
 * 因为注解定义后也是一种class，所有的注解都继承自java.lang.annotation.Annotation，因此，读取注解，需要使用反射API。
 *
 * Java提供的使用反射API读取Annotation的方法包括：
 *
 * 判断某个注解是否存在于Class、Field、Method或Constructor：
 *
 * Class.isAnnotationPresent(Class)
 * Field.isAnnotationPresent(Class)
 * Method.isAnnotationPresent(Class)
 * Constructor.isAnnotationPresent(Class)
 * */