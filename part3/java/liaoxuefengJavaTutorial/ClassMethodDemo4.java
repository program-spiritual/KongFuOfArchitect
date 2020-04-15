public class ClassMethodDemo4 {
    public static void main(String[] args) {
//        上面的setNames()就定义了一个可变参数。调用时，可以这么写：

        Group g = new Group();
//        g.setNames("Xiao Ming", "Xiao Hong", "Xiao Jun"); // 传入3个String
//        g.setNames("Xiao Ming", "Xiao Hong"); // 传入2个String
//        g.setNames("Xiao Ming"); // 传入1个String
//        g.setNames(); // 传入0个String

//        Group g = new Group();
        g.setNames(new String[] {"Xiao Ming", "Xiao Hong", "Xiao Jun"}); // 传入1个String[]

//        而可变参数可以保证无法传入null，因为传入0个参数时，接收到的实际值是一个空数组而不是null。
    }
}

//可变参数用类型...定义，可变参数相当于数组类型：

class Group {
    private String[] names;

    //    public void setNames(String... names) {
//        this.names = names;
//    }
//    完全可以把可变参数改写为String[]类型：
    public void setNames(String[] names) {
        this.names = names;
    }
}