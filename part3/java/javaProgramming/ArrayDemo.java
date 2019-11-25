public class ArrayDemo {
    public ArrayDemo() {
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
    public static int[] reverse(int[] list) {
        int[] result = new int[list.length];

        for (int i = 0, j = result.length - 1; i < list.length; i++, j--) {
            result[j] = list[i];
        }
        return result;
    }
    public static void main(String[] args) {
//        declare an array
        double[] myList = new double[10];
//        processing an array
        double[] myList2 = {1.9, 2.9, 3.4, 3.5};

        // Print all the array elements
        for (int i = 0; i < myList2.length; i++) {
            System.out.println(myList2[i] + " ");
        }
        // Summing all elements
        double total = 0;
        for (int i = 0; i < myList2.length; i++) {
            total += myList2[i];
        }
        System.out.println("Total is " + total);

        // Finding the largest element
        double max = myList2[0];
        for (int i = 1; i < myList2.length; i++) {
            if (myList2[i] > max) max = myList2[i];
        }
        System.out.println("Max is " + max);

        for (double element : myList2) {
            System.out.println(element);
        }
//       passing array to function
        printArray(new int[]{3, 1, 2, 6, 4, 2});
    }
}
