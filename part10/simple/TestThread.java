
public class TestThread {
    public static void main(String[] args) {
        Num num = new Num();

        for (int i = 0; i < 3; i++) {
            new NewThread(num).start();
        }
    }
}

//线程类NewThread 对数字进行操作
class NewThread extends Thread {
    private Num num;

    public NewThread(Num num) {
        this.num = num;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++)
            num.add();
        System.out.println("num.num:" + num.value);
    }
}

//给数字加1
class Num {
    public int value = 0;
    public void add() {
        synchronized (this) {
            value += 1;
        }
    }
}