package multithreads.create;

public class ThreadDemo3 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("start new thread now");

        });
    }
}
