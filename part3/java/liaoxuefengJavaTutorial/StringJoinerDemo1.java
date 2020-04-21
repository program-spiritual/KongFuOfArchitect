import java.util.StringJoiner;

public class StringJoinerDemo1 {
    public static void main(String[] args) {
//        类似用分隔符拼接数组的需求很常见，所以Java标准库还提供了一个StringJoiner来干这个事：
        String[] names = {"Bob", "Alice", "Grace"};
        var sj = new StringJoiner(", ");
        for (String name : names) {
            sj.add(name);
        }
        System.out.println(sj.toString());

//        慢着！用StringJoiner的结果少了前面的"Hello "和结尾的"!"！遇到这种情况，需要给StringJoiner指定“开头”和“结尾”：

        var sj2 = new StringJoiner(", ", "Hello ", "!");
        for (String name : names) {
            sj2.add(name);
        }
        System.out.println(sj2.toString());
    }
}
