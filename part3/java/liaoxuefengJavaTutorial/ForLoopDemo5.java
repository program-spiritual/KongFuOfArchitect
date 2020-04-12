public class ForLoopDemo5 {
    public static void main(String[] args) {
//        for循环经常用来遍历数组，因为通过计数器可以根据索引来访问数组的每个元素：
        int[] ns = { 1, 4, 9, 16, 25 };
        for (int i=0; i<ns.length; i++) {
            System.out.println(ns[i]);
        }
//        但是，很多时候，我们实际上真正想要访问的是数组每个元素的值。Java还提供了另一种for each循环，它可以更简单地遍历数组：
        int[] ns2 = { 1, 4, 9, 16, 25 };
        for (int n : ns) {
            System.out.println(n);
        }

//        和for循环相比，for each循环的变量n不再是计数器，而是直接对应到数组的每个元素。
//       for each循环的写法也更简洁。
//      但是，for each循环无法指定遍历顺序，也无法获取数组的索引。
//
//        除了数组外，for each循环能够遍历所有“可迭代”的数据类型，包括后面会介绍的List、Map等。
    }
}
