public class IfJudgmentDemo3 {
    public static void main(String[] args) {
        int n = 70;
        if (n >= 90) {
            System.out.println("优秀");
        } else if (n >= 60) {
            System.out.println("及格了");
        } else {
            System.out.println("挂科了");
        }
        System.out.println("END");

//       效果相当于
        if (n >= 90) {
            // n >= 90为true:
            System.out.println("优秀");
        } else {
            // n >= 90为false:
            if (n >= 60) {
                // n >= 60为true:
                System.out.println("及格了");
            } else {
                // n >= 60为false:
                System.out.println("挂科了");
            }
        }
    }
}
