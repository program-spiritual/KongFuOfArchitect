package useStack;
/**
 * 在Java中，我们用Deque可以实现Stack的功能：
 *
 * 把元素压栈：push(E)/addFirst(E)；
 * 把栈顶的元素“弹出”：pop(E)/removeFirst()；
 * 取栈顶元素但不弹出：peek(E)/peekFirst()。
 * */
public class Main {
    public static void main(String[] args) {
       System.out.println( foo(123));
    }
    static String foo(int x) {
        return "F-" + bar(x + 1);
    }

    static int bar(int x) {
        return x << 2;
    }
}
