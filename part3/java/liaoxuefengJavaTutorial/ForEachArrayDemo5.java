import java.util.Arrays;
import java.util.Collections;

public class ForEachArrayDemo5 {
    public static void main(String[] args) {
        Integer[] ns = { 28, 12, 89, 73, 65, 18, 96, 50, 8, 36 };
        Arrays.sort(ns, Collections.reverseOrder());
//        排序后
        System.out.println(Arrays.toString(ns));
    }
}
