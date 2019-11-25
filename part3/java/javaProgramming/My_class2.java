class Outer_Demo2 {
    // private variable of the outer class
    private int num = 175;

    // inner class
    public class Inner_Demo {
        public int getNum() {
            System.out.println("This is the getnum method of the inner class");
            return num;
        }
    }
}

public class My_class2 {

    public static void main(String args[]) {
        // Instantiating the outer class
        Outer_Demo2 outer = new Outer_Demo2();

        // Instantiating the inner class
        Outer_Demo2.Inner_Demo inner = outer.new Inner_Demo();
        System.out.println(inner.getNum());
    }
}