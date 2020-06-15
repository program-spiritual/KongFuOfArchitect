package multithreads.waitAndNotify;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        var q = new TaskQueue();
        var ts = new ArrayList<Thread>();

        for (int i = 0; i < 5; i++) {
            var t = new Thread() {
                public void run() {
                    // 执行task:
                    while (true) {
                        String s = q.getTask();
                        System.out.println("execute task: " + s);
                    }
                }
            };
            t.start();
            ts.add(t);
        }

        var add = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                // 放入task:
                String s = "t-" + Math.random();
                System.out.println("add task: " + s);
                q.addTask(s);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        });

        add.start();
        try {
            add.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (var t : ts) {
            t.interrupt();
        }
    }
}
