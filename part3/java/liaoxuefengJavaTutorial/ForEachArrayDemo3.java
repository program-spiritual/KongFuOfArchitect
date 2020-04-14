import java.util.Arrays;

public class ForEachArrayDemo3 {
//    我们来看一下如何使用冒泡排序算法对一个整型数组从小到大进行排序：
    public static void main(String[] args) {
        int[] ns = { 28, 12, 89, 73, 65, 18, 96, 50, 8, 36 };
        // 排序前:
        System.out.println(Arrays.toString(ns));
        for (int i = 0; i < ns.length-1; i++) {
            for (int j = 0; j < ns.length - i - 1; j++) {
                if (ns[j] > ns[j + 1]) {
                    int tmp = ns[j];
                    ns[j] = ns[j + 1];
                    ns[j + 1] = tmp;
                }
            }
        }
//        冒泡排序 结束后
        System.out.println(Arrays.toString(ns));
    }
}
