package strategy.order;

public class OrderService {
    public double discount(Order order) {
        double discount = 0.0;
        OrderType type = order.getType();

        if (type.equals(OrderType.NORMAL)) { // 普通订单
        } else if (type.equals(OrderType.GROUPON)) { // 团购订单      //...省略折扣计算算法代码
        } else if (type.equals(OrderType.PROMOTION)) {      //...省略折扣计算算法代码
        }
        return discount;
    }
}
