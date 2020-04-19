public class IntefaceDemo3 {
    public static void main(String[] args) {

    }
}

// 一个interface可以继承自另一个interface。interface继承自interface使用extends，它相当于扩展了接口的方法。例如：
//

interface Hello3 {
    void hello();
}

interface Person19 extends Hello3 {
    void run();
    String getName();
}

//此时，Person接口继承自Hello接口，因此，Person接口现在实际上有3个抽象方法签名，其中一个来自继承的Hello接口。