public class ReflectClassDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//除了int等基本类型外，Java的其他类型全部都是class（包括interface）。例如：
//
//String
//Object
//Runnable
//Exception

//        仔细思考，我们可以得出结论：class（包括interface）的本质是数据类型（Type）。无继承关系的数据类型无法赋值：
//        Number n = new Double(123.456); // OK
//        String s = new Double(123.456); // compile error!
//        而class是由JVM在执行过程中动态加载的。JVM在第一次读取到一种class类型时，将其加载进内存。
//
//        每加载一种class，JVM就为其创建一个Class类型的实例，并关联起来。注意：这里的Class类型是一个名叫Class的class。它长这样：
//        public final class Class {
//              private Class() {}
//        }
//        以String类为例，当JVM加载String类时，它首先读取String.class文件到内存，然后，为String类创建一个Class实例并关联起来：
//        Class cls = new Class(String);
//        这个Class实例是JVM内部创建的，如果我们查看JDK源码，可以发现Class类的构造方法是private，只有JVM能创建Class实例，我们自己的Java程序是无法创建Class实例的。
//
//        所以，JVM持有的每个Class实例都指向一个数据类型（class或interface）：
        /**
         * ┌───────────────────────────┐
         * │      Class Instance       │──────> String
         * ├───────────────────────────┤
         * │name = "java.lang.String"  │
         * └───────────────────────────┘
         * ┌───────────────────────────┐
         * │      Class Instance       │──────> Random
         * ├───────────────────────────┤
         * │name = "java.util.Random"  │
         * └───────────────────────────┘
         * ┌───────────────────────────┐
         * │      Class Instance       │──────> Runnable
         * ├───────────────────────────┤
         * │name = "java.lang.Runnable"│
         * └───────────────────────────┘
         *
         *
         * 一个Class实例包含了该class的所有完整信息：
         *
         * ┌───────────────────────────┐
         * │      Class Instance       │──────> String
         * ├───────────────────────────┤
         * │name = "java.lang.String"  │
         * ├───────────────────────────┤
         * │package = "java.lang"      │
         * ├───────────────────────────┤
         * │super = "java.lang.Object" │
         * ├───────────────────────────┤
         * │interface = CharSequence...│
         * ├───────────────────────────┤
         * │field = value[],hash,...   │
         * ├───────────────────────────┤
         * │method = indexOf()...      │
         * └───────────────────────────┘
         * 由于JVM为每个加载的class创建了对应的Class实例，并在实例中保存了该class的所有信息，包括类名、包名、父类、实现的接口、所有方法、字段等，因此，如果获取了某个Class实例，我们就可以通过这个Class实例获取到该实例对应的class的所有信息。
         *
         * 这种通过Class实例获取class信息的方法称为反射（Reflection）。
         * */

//        如何获取一个class的Class实例？有三个方法：
//
//        方法一：直接通过一个class的静态变量class获取：

        Class cls1 = String.class;
        System.out.println(cls1);

//        方法二：如果我们有一个实例变量，可以通过该实例变量提供的getClass()方法获取：
//
        String s = "Hello";
        Class cls2 = s.getClass();
        System.out.println(cls2);
//        方法三：如果知道一个class的完整类名，可以通过静态方法Class.forName()获取：
        Class cls3 = Class.forName("java.lang.String");
        System.out.println(cls3);
        boolean sameClass = cls1 == cls2; // true
//        注意一下Class实例比较和instanceof的差别：
        Integer n1 = 123;

        boolean b1 = n1 instanceof Integer; // true，因为n是Integer类型
        boolean b2 = n1 instanceof Number; // true，因为n是Number类型的子类

        boolean b3 = n1.getClass() == Integer.class; // true，因为n.getClass()返回Integer.class
//        boolean b4 = n1.getClass() == Number.class; // false，因为Integer.class!=Number.class

//      用instanceof不但匹配指定类型，还匹配指定类型的子类。而用==判断class实例可以精确地判断数据类型，但不能作子类型比较。
//
//通常情况下，我们应该用instanceof判断数据类型，因为面向抽象编程的时候，我们不关心具体的子类型。只有在需要精确判断一个类型是不是某个class的时候，我们才使用==判断class实例。
//
//因为反射的目的是为了获得某个实例的信息。因此，当我们拿到某个Object实例时，我们可以通过反射获取该Object的class信息：

        printClassInfo("".getClass());
        printClassInfo(Runnable.class);
        printClassInfo(java.time.Month.class);
        printClassInfo(String[].class);
        printClassInfo(int.class);
//        注意到数组（例如String[]）也是一种Class，而且不同于String.class，它的类名是[Ljava.lang.String。此外，JVM为每一种基本类型如int也创建了Class，通过int.class访问。
//
//如果获取到了一个Class实例，我们就可以通过该Class实例来创建对应类型的实例：

//        如果获取到了一个Class实例，我们就可以通过该Class实例来创建对应类型的实例：

// 获取String的Class实例:
        Class cls4 = String.class;
// 创建一个String实例:
        String s2 = (String) cls4.newInstance();
        System.out.println("S2"+s2);
//        上述代码相当于new String()。通过Class.newInstance()可以创建类实例，
//       它的局限是：只能调用public的无参数构造方法。
//      带参数的构造方法，或者非public的构造方法都无法通过Class.newInstance()被调用。
    }

    void printObjectInfo(Object obj) {
        Class cls = obj.getClass();
    }
//    要从Class实例获取获取的基本信息，参考下面的代码：

    static void printClassInfo(Class cls) {
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple name: " + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("Package name: " + cls.getPackage().getName());
        }
        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        System.out.println("is primitive: " + cls.isPrimitive());
    }
}
