public class StringBuilderDemo2 {
    public static void main(String[] args) {
        Adder adder = new Adder(0);
        adder.add(3)
                .add(5)
                .inc()
                .add(10);
        System.out.println(adder.value());

//        注意：对于普通的字符串+操作，并不需要我们将其改写为StringBuilder，因为Java编译器在编译时就自动把多个连续的+操作编码为StringConcatFactory的操作。在运行期，StringConcatFactory会自动把字符串连接操作优化为数组复制或者StringBuilder操作。
//
//你可能还听说过StringBuffer，这是Java早期的一个StringBuilder的线程安全版本，它通过同步来保证多个线程操作StringBuffer也是安全的，但是同步会带来执行速度的下降。
//
//StringBuilder和StringBuffer接口完全相同，现在完全没有必要使用StringBuffer。
    }
}

class Adder {
    private int sum = 0;

    public Adder(int sum) {
        this.sum = sum;
    }

    public Adder add(int n) {
        sum += n;
        return this;
    }

    public Adder inc() {
        sum++;
        return this;
    }
    public int value() {
        return sum;
    }
}