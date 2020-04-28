import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class AccessFieldsDemo1 {
    /**
     * 我们先看看如何通过Class实例获取字段信息。Class类提供了以下几个方法来获取字段：
     *
     * Field getField(name)：根据字段名获取某个public的field（包括父类）
     * Field getDeclaredField(name)：根据字段名获取当前类的某个field（不包括父类）
     * Field[] getFields()：获取所有public的field（包括父类）
     * Field[] getDeclaredFields()：获取当前类的所有field（不包括父类）
     * */
    public static void main(String[] args) throws NoSuchFieldException {
        Class stdClass = Student23.class;
        // 获取public字段"score":
        System.out.println(stdClass.getField("score"));
        // 获取继承的public字段"name":
        System.out.println(stdClass.getField("name"));
        // 获取private字段"grade":
        System.out.println(stdClass.getDeclaredField("grade"));

//        一个Field对象包含了一个字段的所有信息：
        //
        //getName()：返回字段名称，例如，"name"；
        //getType()：返回字段类型，也是一个Class实例，例如，String.class；
        //getModifiers()：返回字段的修饰符，它是一个int，不同的bit表示不同的含义。
//我们用反射获取该字段的信息，代码如下：
        Field f = String.class.getDeclaredField("value");
        f.getName(); // "value"
        f.getType(); // class [B 表示byte[]类型
        int m = f.getModifiers();
        Modifier.isFinal(m); // true
        Modifier.isPublic(m); // false
        Modifier.isProtected(m); // false
        Modifier.isPrivate(m); // true
        Modifier.isStatic(m); // false
    }
}

class Student23 extends Person023{
    public int score;
    private int grade;
}

class Person023 {
    public String name;
}

