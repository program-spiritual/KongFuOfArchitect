package strategy.order;

public class GrouponDiscountStrategy implements DiscountStrategy{
    @Override
    public double calDiscount(Order order) {
        return 0;
    }
}
