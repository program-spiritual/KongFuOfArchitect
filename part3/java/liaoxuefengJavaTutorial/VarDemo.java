public class VarDemo {
    public static void main(String[] args) {
//        StringBuilder sb = new StringBuilder();
        var sb = new StringBuilder();
        System.out.println(sb);
//        编译器会根据赋值语句自动推断出变量sb的类型是StringBuilder。对编译器来说，语句：
//
//        var sb = new StringBuilder();
//        实际上会自动变成：
//
//        StringBuilder sb = new StringBuilder();
//        因此，使用var定义变量，仅仅是少写了变量类型而已。
    }
}
