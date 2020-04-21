public class StringJoinerDemo2 {
    public static void main(String[] args) {
//        String还提供了一个静态方法join()，这个方法在内部使用了StringJoiner来拼接字符串，在不需要指定“开头”和“结尾”的时候，用String.join()更方便：
        String[] names = {"Bob", "Alice", "Grace"};
        var s = String.join(", ", names);
        System.out.println(s);
    }
}
