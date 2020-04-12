public class ForLoopDemo3 {
    public static void main(String[] args) {
        int[] ns = { 1, 4, 9, 16, 25 };
        for (int i=0; i<ns.length; i=i+2) {
            System.out.println(ns[i]);
        }
    }
}
