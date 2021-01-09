package strategy.order;

public class PromotionDiscountStrategy implements DiscountStrategy{
    @Override
    public double calDiscount(Order order) {
        return 0;
    }
}
