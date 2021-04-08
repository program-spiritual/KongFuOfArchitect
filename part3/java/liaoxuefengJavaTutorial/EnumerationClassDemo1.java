public class EnumerationClassDemo1 {

  public static void main(String[] args) {
    var day = 6;
    if (day == Weekday.SAT || day == Weekday.SUN) {
      // TODO: work at home
      System.out.println("周末");
    }

    String color = "g";
    if (Color.RED.equals(color)) {
      // TODO:
    }

    //无论是int常量还是String常量，使用这些常量来表示一组枚举值的时候，
    //有一个严重的问题就是，编译器无法检查每个值的合理性。例如：
    var weekday = 0;
    var tasks = 1;
    if (weekday == 6 || weekday == 7) {
      if (tasks == Weekday.MON) {
        // TODO:
      }
    }
    // 上述代码编译和运行均不会报错，但存在两个问题：
    //
    //注意到Weekday定义的常量范围是0~6，并不包含7，编译器无法检查不在枚举中的int值；
    //定义的常量仍可与其他变量比较，但其用途并非是枚举星期值。

    //        注意到定义枚举类是通过关键字enum实现的，我们只需依次列出枚举的常量名。
    //
    //和int定义的常量相比，使用enum定义枚举有如下好处：
    //
    //首先，enum常量本身带有类型信息，即Weekday.SUN类型是Weekday，编译器会自动检查出类型错误。例如，下面的语句不可能编译通过：
    int day2 = 1;
    //        if (day2 == Weekday2.SUN) { // Compile error: bad operand types for binary operator '=='
    //        }

    //        其次，不可能引用到非枚举的值，因为无法通过编译。
    //
    //最后，不同类型的枚举不能互相比较或者赋值，因为类型不符。例如，不能给一个Weekday枚举类型的变量赋值为Color枚举类型的值：
    Weekday2 x = Weekday2.SUN; // ok!
    //        Weekday2 y = Color.RED; // Compile error: incompatible types

  }
}

//在Java中，我们可以通过static final来定义常量。例如，我们希望定义周一到周日这7个常量，可以用7个不同的int表示：

class Weekday {

  public static final int SUN = 0;
  public static final int MON = 1;
  public static final int TUE = 2;
  public static final int WED = 3;
  public static final int THU = 4;
  public static final int FRI = 5;
  public static final int SAT = 6;
}

//也可以把常量定义为字符串类型，例如，定义3种颜色的常量：

class Color {

  public static final String RED = "r";
  public static final String GREEN = "g";
  public static final String BLUE = "b";
}

//为了让编译器能自动检查某个值在枚举的集合内，并且，不同用途的枚举需要不同的类型来标记，不能混用，我们可以使用enum来定义枚举类：

enum Weekday2 {
  MON(1),
  TUE(2),
  WED(3),
  THU(4),
  FRI(5),
  SAT(6),
  SUN(0);

  Weekday2(int i) {}
}
