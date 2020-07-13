package useEnumMap;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        如果Map的key是enum类型，推荐使用EnumMap，既保证速度，也不浪费空间。
//
//使用EnumMap的时候，根据面向抽象编程的原则，应持有Map接口
        Map<DayOfWeek, String> map = new EnumMap<>(DayOfWeek.class);
        map.put(DayOfWeek.MONDAY, "星期一");
        map.put(DayOfWeek.TUESDAY, "星期二");
        map.put(DayOfWeek.WEDNESDAY, "星期三");
        map.put(DayOfWeek.THURSDAY, "星期四");
        map.put(DayOfWeek.FRIDAY, "星期五");
        map.put(DayOfWeek.SATURDAY, "星期六");
        map.put(DayOfWeek.SUNDAY, "星期日");
        System.out.println(map);
        System.out.println(map.get(DayOfWeek.MONDAY));
    }
}
