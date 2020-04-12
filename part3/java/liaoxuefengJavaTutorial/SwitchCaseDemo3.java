public class SwitchCaseDemo3 {
    public static void main(String[] args) {
        String fruit = "apple";
        int opt;
        switch (fruit) {
            case "apple":
                opt = 1;
                break;
            case "pear":
            case "mango":
                opt = 2;
                break;
            default:
                opt = 0;
                break;
        }

//        使用新的switch语法，不但不需要break，还可以直接返回值。把上面的代码改写如下：
        int opt2 = switch (fruit) {
            case "apple" -> 1;
            case "pear", "mango" -> 2;
            default -> 0;
        }; // 注意赋值语句要以;结束
        System.out.println("opt = " + opt2);

    }
}
