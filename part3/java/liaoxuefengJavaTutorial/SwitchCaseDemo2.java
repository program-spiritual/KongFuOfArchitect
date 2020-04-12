public class SwitchCaseDemo2 {
    public static void main(String[] args) {
        int option = 2;
        switch (option) {
            case 1 -> System.out.println("Selected 1");
            case 2, 3 -> System.out.println("Selected 2, 3");
            default -> System.out.println("Not selected");
        }

//        使用switch语句时，只要保证有break，case的顺序不影响程序逻辑：
//        switch语句还可以匹配字符串。字符串匹配时，是比较“内容相等”。例如：
        String fruit = "apple";
        switch (fruit) {
            case "apple" -> System.out.println("Selected apple");
            case "pear" -> System.out.println("Selected pear");
            case "mango" -> System.out.println("Selected mango");
            default -> System.out.println("No fruit selected");
        }

//        从Java 12开始，switch语句升级为更简洁的表达式语法，使用类似模式匹配（Pattern Matching）的方法，
//       保证只有一种路径会被执行，并且不需要break语句：
        switch (fruit) {
            case "apple" -> System.out.println("Selected apple");
            case "pear" -> System.out.println("Selected pear");
            case "mango" -> {
                System.out.println("Selected mango");
                System.out.println("Good choice!");
            }
            default -> System.out.println("No fruit selected");
        }
    }
}
