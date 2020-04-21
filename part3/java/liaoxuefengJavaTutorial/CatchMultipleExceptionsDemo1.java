import java.io.IOException;

public class CatchMultipleExceptionsDemo1 {
    public static void main(String[] args) {
//        因为处理IOException和NumberFormatException的代码是相同的，所以我们可以把它两用|合并到一起：
        try {
            process1();
            process2();
            process3();
        } catch (IOException | NumberFormatException e) { // IOException或NumberFormatException
            System.out.println("Bad input");
        } catch (Exception e) {
            System.out.println("Unknown error");
        }
    }

    private static void process3() throws IOException {
        throw new IOException();
    }

    private static void process2() {
        throw new NumberFormatException();
    }

    private static void process1() {

    }
}
