package flyweight.autoBoxing;

public class Demo1 {
    public static void main(String[] args) {

        Integer i1 = 56;
        Integer i2 = 56;
        Integer i3 = 129;
        Integer i4 = 129;
        System.out.println(i1 == i2);
        System.out.println(i3 == i4);
    }
}
