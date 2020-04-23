import java.io.FileInputStream;
import java.util.Optional;

public class NullPointerExceptionDemo2 {
    public static void main(String[] args) {
//        如果遇到NullPointerException，我们应该如何处理？首先，必须明确，
//       NullPointerException是一种代码逻辑错误，遇到NullPointerException，遵循原则是早暴露，早修复，严禁使用catch来隐藏这种编码错误：
        // 错误示例: 捕获NullPointerException
        try {
            String from = null;
            String to = null;
            int amount = 1;
            transferMoney(from, to, amount);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static void transferMoney(String from, String to, int amount) {
        from.toLowerCase();
    }

    //    返回空字符串""、空数组而不是null：
    public String[] readLinesFromFile(String file) {
        if (getFileSize(file) == 0) {
            // 返回空数组而不是null:
            return new String[0];
        }
        return new String[0];
    }

    private int getFileSize(String file) {
        return 0;
    }

//    如果调用方一定要根据null判断，比如返回null表示文件不存在，那么考虑返回Optional<T>：
//    这样调用方必须通过Optional.isPresent()判断是否有结果。
public Optional<String> readFromFile(String file) {
    if (!fileExist(file)) {
        return Optional.empty();
    }
    return null;
}

    private boolean fileExist(String file) {
        return false;
    }
}

//好的编码习惯可以极大地降低NullPointerException的产生，例如：
//
//成员变量在定义时初始化：
//
class NullPointerExceptionChild1 {
    private String name = "";
}
//使用空字符串""而不是默认的null可避免很多NullPointerException，编写业务逻辑时，用空字符串""表示未填写比null安全得多