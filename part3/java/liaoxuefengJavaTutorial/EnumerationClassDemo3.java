public class EnumerationClassDemo3 {
    /**
     * 通过enum定义的枚举类，和其他的class有什么区别？
     *
     * 答案是没有任何区别。enum定义的类型就是class，只不过它有以下几个特点：
     *
     * 定义的enum类型总是继承自java.lang.Enum，且无法被继承；
     * 只能定义出enum的实例，而无法通过new操作符创建enum的实例；
     * 定义的每个实例都是引用类型的唯一实例；
     * 可以将enum类型用于switch语句。
     *
     * */
    public static void main(String[] args) {
        // 返回常量名
        String s = Weekday2.THU.name();
//     返回定义的常量顺序 从 0 计数开始
        int n = Weekday2.MON.ordinal(); // 1
//        改变枚举常量定义的顺序就会导致ordinal()返回值发生变化

//        但是，如果不小心修改了枚举的顺序，编译器是无法检查出这种逻辑错误的。要编写健壮的代码，
//       就不要依靠ordinal()的返回值。
//      因为enum本身是class，所以我们可以定义private的构造方法，
//      并且，给每个枚举常量添加字段：


        WeekDay3 day = WeekDay3.SUN;
        if (day.dayValue == 6 || day.dayValue == 0) {
            System.out.println("Work at home!");
        } else {
            System.out.println("Work at office!");
        }

        WeekDay3 day2 = WeekDay3.SUN;
        if (day2.dayValue == 6 || day2.dayValue == 0) {
            System.out.println("Today is " + day2 + ". Work at home!");
        } else {
            System.out.println("Today is " + day2 + ". Work at office!");
        }
    }
}

//所以，编译后的enum类和普通class并没有任何区别。但是我们自己无法按定义普通class那样来定义enum，必须使用enum关键字，这是Java语法规定的。
//
//因为enum是一个class，每个枚举的值都是class实例，因此，这些实例有一些方法：

enum  WeekDay3{
    MON(1,"星期一"), TUE(2, "星期二"), WED(3, "星期三"), THU(4, "星期四"), FRI(5, "星期五"), SAT(6, "星期六"), SUN(0, "星期日");

//：枚举类的字段也可以是非final类型，即可以在运行期修改，但是不推荐这样做！
    public final int dayValue;
    public final String chinese;

    WeekDay3(int dayValue, String chinese) {
        this.dayValue = dayValue;
        this.chinese = chinese;
    }

    @Override
    public String toString() {
        return this.chinese;
    }


//    我们可以给Weekday添加toString()方法：
//：判断枚举常量的名字，要始终使用name()方法，绝不能调用toString()
}