
public class TestVolatile {
    public static void main(String[] args) {
        new TestVolatile().doTest();
    }

    public void doTest(){
        Num num = new Num();
        new MyThread1(num).start();
        new MyThread2(num).start();
    }

    //线程1:读取Num.value的值。如果该值发生了变化，那么就打印出来。
    class MyThread1 extends Thread {
        private Num num;
        public MyThread1(Num num) {
            this.num = num;
        }

        @Override
        public void run() {
            int localValue = num.value;
            while (localValue < 10){
                if (localValue != num.value){ //发现num.value变了
                    System.out.println("Value changed to: " + num.value);
                    localValue = num.value;
                }
            }
        }
    }

    //线程2：修改Num.value的值。
    class MyThread2 extends Thread {
        private Num num;
        public MyThread2(Num num) {
            this.num = num;
        }

        @Override
        public void run() {
            int localValue = num.value;
            while(num.value < 10){
                localValue ++;
                System.out.println("Change value to: " + localValue);
                num.value = localValue;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Num {
        public volatile int value = 0;  //用volatile关键字修饰value
    }
}