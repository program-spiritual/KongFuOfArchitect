import java.util.Arrays;

public class MultidimensionalArraysDemo3 {
    /**
     *这个二维数组在内存中的结构如下：
     *
     *                     ┌───┬───┬───┬───┐
     *          ┌───┐  ┌──>│ 1 │ 2 │ 3 │ 4 │
     * ns ─────>│░░░│──┘   └───┴───┴───┴───┘
     *          ├───┤      ┌───┬───┐
     *          │░░░│─────>│ 5 │ 6 │
     *          ├───┤      └───┴───┘
     *          │░░░│──┐   ┌───┬───┬───┐
     *          └───┘  └──>│ 7 │ 8 │ 9 │
     *                     └───┴───┴───┘
     * */
    public static void main(String[] args) {
        int[][] ns = {
                { 1, 2, 3, 4 },
                { 5, 6 },
                { 7, 8, 9 }
        };
//        要打印一个二维数组，可以使用两层嵌套的for循环：

        for (int[] arr : ns) {
            for (int n : arr) {
                System.out.print(n);
                System.out.print(',');
            }
            System.out.println();
        }

//        或者使用Java标准库的Arrays.deepToString()：
        System.out.println(Arrays.deepToString(ns));
    }
}
