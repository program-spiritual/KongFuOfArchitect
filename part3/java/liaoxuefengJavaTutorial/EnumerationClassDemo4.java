public class EnumerationClassDemo4 {

  public static void main(String[] args) {
    Weekday4 day = Weekday4.SUN;
    switch (day) {
      case MON:
      case TUE:
      case WED:
      case THU:
      case FRI:
        System.out.println("Today is " + day.name() + ". Work at office!");
        break;
      case SAT:
      case SUN:
        System.out.println("Today is " + day.name() + ". Work at home!");
        break;
      default:
        throw new RuntimeException("cannot process " + day);
    }
  }
}

//最后，枚举类可以应用在switch语句中。因为枚举类天生具有类型信息和有限个枚举常量，所以比int、String类型更适合用在switch语句中：

enum Weekday4 {
  MON,
  TUE,
  WED,
  THU,
  FRI,
  SAT,
  SUN,
}
