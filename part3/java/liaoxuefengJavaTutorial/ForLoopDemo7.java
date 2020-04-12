public class ForLoopDemo7 {
    public static void main(String[] args) {
//        break会跳出当前循环，也就是整个循环都不会执行了。而continue则是提前结束本次循环，直接继续执行下次循环。我们看一个例子：
        int sum = 0;
        for (int i=1; i<=10; i++) {
            System.out.println("begin i = " + i);
            if (i % 2 == 0) {
                continue; // continue语句会结束本次循环
            }
            sum = sum + i;
            System.out.println("end i = " + i);
        }
        System.out.println(sum); // 25

//        注意观察continue语句的效果。当i为奇数时，完整地执行了整个循环，
//       因此，会打印begin i=1和end i=1。在i为偶数时，continue语句会提前结束本次循环，
//      因此，会打印begin i=2但不会打印end i = 2。
//        在多层嵌套的循环中，continue语句同样是结束本次自己所在的循环。
    }
}
