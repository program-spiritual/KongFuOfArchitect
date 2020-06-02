package datetime.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
// 获取当前时间:
//        注意
//       getYear()返回的年份必须加上1900，
//       getMonth()返回的月份是0~11分别表示1~12月，所以要加1，
//      而getDate()返回的日期范围是1~31，又不能加1。
        Date date = new Date();
        System.out.println(date.getYear() + 1900); // 必须加上1900
        System.out.println(date.getMonth() + 1); // 0~11，必须加上1
        System.out.println(date.getDate()); // 1~31，不能加1
        // 转换为String:
        System.out.println(date.toString());
        // 转换为GMT时区:
        System.out.println(date.toGMTString());
        // 转换为本地时区:
        System.out.println(date.toLocaleString());

//        打印本地时区表示的日期和时间时，不同的计算机可能会有不同的结果。
//       如果我们想要针对用户的偏好精确地控制日期和时间的格式，
//      就可以使用SimpleDateFormat对一个Date进行转换。它用预定义的字符串表示格式化：
       var sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       System.out.println(sdf.format(date));
//       Date对象有几个严重的问题：它不能转换时区，除了toGMTString()可以按GMT+0:00输出外，
//      Date总是以当前计算机系统的默认时区为基础进行输出。
//     此外，我们也很难对日期和时间进行加减，计算两个日期相差多少天，计算某个月第一个星期一的日期等。
    }
}
