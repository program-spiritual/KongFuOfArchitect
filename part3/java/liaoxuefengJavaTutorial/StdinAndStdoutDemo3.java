import java.util.Scanner;
public class StdinAndStdoutDemo3 {
    /**
     * 首先，我们通过import语句导入java.util.Scanner，import是导入某个类的语句，
     * 必须放到Java源代码的开头，后面我们在Java的package中会详细讲解如何使用import。
     *
     * 然后，创建Scanner对象并传入System.in。System.out代表标准输出流，而System.in代表标准输入流。
     * 直接使用System.in读取用户输入虽然是可以的，但需要更复杂的代码，而通过Scanner就可以简化后续的代码。
     *
     * 有了Scanner对象后，要读取用户输入的字符串，使用scanner.nextLine()，要读取用户输入的整数，使用scanner.nextInt()。
     * Scanner会自动转换数据类型，因此不必手动转换。
     *
     * 要测试输入，我们不能在线运行它，因为输入必须从命令行读取，因此，需要走编译、执行的流程：
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 创建Scanner对象
        System.out.print("Input your name: "); // 打印提示
        String name = scanner.nextLine(); // 读取一行输入并获取字符串
        System.out.print("Input your age: "); // 打印提示
        int age = scanner.nextInt(); // 读取一行输入并获取整数
        System.out.printf("Hi, %s, you are %d\n", name, age); // 格式化输出
    }
}
