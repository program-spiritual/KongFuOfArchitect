public class PackagingType {
    public static void main(String[] args) {
//        引用类型可以赋值为null，表示空，但基本类型不能赋值为null：
        Integer n = null;
        Integer2 n2 = new Integer2(99);
        int n3 = n2.intValue();

        int i = 100;
        // 通过new操作符创建Integer实例(不推荐使用,会有编译警告):
//        Integer n1 = new Integer(i);
        // 通过静态方法valueOf(int)创建Integer实例:
        Integer integerValue1 = Integer.valueOf(i);
        // 通过静态方法valueOf(String)创建Integer实例:
        Integer integerValue2 = Integer.valueOf("100");
        System.out.println(integerValue2.intValue());
    }
}

//那么，如何把一个基本类型视为对象（引用类型）？
//
//比如，想要把int基本类型变成一个引用类型，我们可以定义一个Integer类，它只包含一个实例字段int，这样，Integer类就可以视为int的包装类（Wrapper Class）：

class Integer2{
    private int value;

    public Integer2(int value) {
        this.value = value;
    }

    public int intValue() {
        return this.value;
    }
}

/**
 * 实际上，因为包装类型非常有用，Java核心库为每种基本类型都提供了对应的包装类型：
 *
 * 基本类型	对应的引用类型
 * boolean	java.lang.Boolean
 * byte	    java.lang.Byte
 * short	java.lang.Short
 * int	    java.lang.Integer
 * long  	java.lang.Long
 * float	java.lang.Float
 * double	java.lang.Double
 * char	    java.lang.Character
 * */