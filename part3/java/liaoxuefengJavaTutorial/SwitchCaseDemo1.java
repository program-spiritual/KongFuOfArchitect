public class SwitchCaseDemo1 {

  /***
   * 除了if语句外，还有一种条件判断，是根据某个表达式的结果，分别去执行不同的分支。
   *
   * 例如，在游戏中，让用户选择选项：
   *
   * 单人模式
   * 多人模式
   * 退出游戏
   * 这时，switch语句就派上用场了。
   *
   * switch语句根据switch (表达式)计算的结果，跳转到匹配的case结果，然后继续执行后续语句，直到遇到break结束执行。
   * */
  public static void main(String[] args) {
    int option = 2;
    //        修改option的值分别为1、2、3，观察执行结果。
    //
    //        如果option的值没有匹配到任何case，例如option = 99，那么，switch语句不会执行任何语句。这时，可以给switch语句加一个default，当没有匹配到任何case时，执行default：
    switch (option) {
      case 1 -> System.out.println("Selected 1");
      case 2 -> System.out.println("Selected 2");
      case 3 -> System.out.println("Selected 3");
      default -> System.out.println("Not selected");
    }
    //        使用switch时，注意case语句并没有花括号{}，而且，case语句具有“穿透性”，漏写break将导致意想不到的结果：
  }
}
