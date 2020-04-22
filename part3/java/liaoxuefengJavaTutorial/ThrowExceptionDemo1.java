public class ThrowExceptionDemo1 {
    public static void main(String[] args) {
        try {
            process1();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void process1() {
        process2();
    }

    static void process2() {
        Integer.parseInt(null); // 会抛出NumberFormatException
    }

    static void process3(String s) {
        if (s==null) {
//            实际上，绝大部分抛出异常的代码都会合并写成一行：
            throw new NullPointerException();
        }
    }
}


//当某个方法抛出了异常时，如果当前方法没有捕获异常，异常就会被抛到上层调用方法，直到遇到某个try ... catch被捕获为止
