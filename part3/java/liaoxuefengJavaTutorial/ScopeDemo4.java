public class ScopeDemo4 {
    public static void main(String[] args) {
//在方法内部定义的变量称为局部变量，局部变量作用域从变量声明处开始到对应的块结束。方法参数也是局部变量。
    }

    void hi(String name) { // ①
        String s = name.toLowerCase(); // ②
        int len = s.length(); // ③
        if (len < 10) { // ④
            int p = 10 - len; // ⑤
            for (int i=0; i<10; i++) { // ⑥
                System.out.println(); // ⑦
            } // ⑧
        } // ⑨
    } // ⑩

    /**
     * 我们观察上面的hi()方法代码：
     *
     * 方法参数name是局部变量，它的作用域是整个方法，即①～⑩；
     *
     * 变量s的作用域是定义处到方法结束，即②～⑩；
     *
     * 变量len的作用域是定义处到方法结束，即③～⑩；
     *
     * 变量p的作用域是定义处到if块结束，即⑤～⑨；
     *
     * 变量i的作用域是for循环，即⑥～⑧。
     *
     * 使用局部变量时，应该尽可能把局部变量的作用域缩小，尽可能延后声明局部变量。
     * */
}
