package regex.searchAndReplace;

public class Main {
    public static void main(String[] args) {
//        使用正则表达式分割字符串可以实现更加灵活的功能。String.split()方法传入的正是正则表达式。我们来看下面的代码：

        "a b c".split("\\s"); // { "a", "b", "c" }
        "a b  c".split("\\s"); // { "a", "b", "", "c" }
        "a, b ;; c".split("[\\,\\;\\s]+"); // { "a", "b", "c" }

    }
}
