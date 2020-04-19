public class ExtendDemo6 {
    public static void main(String[] args) {
//从Java 14开始，判断instanceof后，可以直接转型为指定变量，避免再次强制转型。例如，对于以下代码：
        Object obj = "hello";
        if (obj instanceof String) {
            String s = (String) obj;
            System.out.println(s.toUpperCase());
        }
// 新的写法
        if (obj instanceof String s) {
            // 可以直接使用变量s:
            System.out.println(s.toUpperCase());
        }
    }
}
