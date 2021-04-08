package com.learnjava.www.behavioralPatterns.mediator;

public class Main {

  public static void main(String[] args) {
    new OrderFrame("汉堡", "鸡块", "薯条", "咖啡");
    /**
     * 使用Mediator模式后，我们得到了以下好处：
     *
     * 各个UI组件互不引用，这样就减少了组件之间的耦合关系；
     * Mediator用于当一个组件发生状态变化时，根据当前所有组件的状态决定更新某些组件；
     * 如果新增一个UI组件，我们只需要修改Mediator更新状态的逻辑，现有的其他UI组件代码不变。
     *
     * Mediator模式经常用在有众多交互组件的UI上。为了简化UI程序，MVC模式以及MVVM模式都可以看作是Mediator模式的扩展。
     * */
  }
}
