package strategy.common;

public class Demo {
    public static void main(String[] args) {
        var a = StrategyFactory.getStrategy("A");
        System.out.println(a);
        var b = NewStrategyFactory.getStrategy("B");
        System.out.println(b);
    }
}
