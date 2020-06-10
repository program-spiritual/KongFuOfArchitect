package multithreads.create;

public class Main {
    public static void main(String[] args) {
//        要创建一个新线程非常容易，我们需要实例化一个Thread实例，然后调用它的start()方法：
        Thread thread = new Thread();
        thread.start();
    }
}
