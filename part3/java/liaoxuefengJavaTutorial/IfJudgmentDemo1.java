public class IfJudgmentDemo1 {
    public static void main(String[] args) {
        int n = 70;
        //        当if语句块只有一行语句时，可以省略花括号{}

        if (n >= 60)
            System.out.println("及格了");
            System.out.println("恭喜你"); // 注意这条语句不是if语句块的一部分
//        但是，省略花括号并不总是一个好主意。假设某个时候，突然想给if语句块增加一条语句时
//        由于使用缩进格式，很容易把两行语句都看成if语句的执行块，但实际上只有第一行语句是if的执行块。在使用git这些版本控制系统自动合并时更容易出问题，所以不推荐忽略花括号的写法。
        System.out.println("END");
    }
}
