public class JavaExceptionDemo1 {
    public static void main(String[] args) {
//        方法一：约定返回错误码。
//
//例如，处理一个文件，如果返回0，表示成功，返回其他整数，表示约定的错误码：
        int code = processFile("C:\\test.txt");
        if (code == 0) {
            // ok:
        } else {
            // error:
            switch (code) {
                case 1:
                    // file not found:
                case 2:
                    // no read permission:
                default:
                    // unknown error:
            }
        }

//        因为使用int类型的错误码，想要处理就非常麻烦。这种方式常见于底层C函数。
    }

    private static int processFile(String s) {
        return 0;
    }
}
