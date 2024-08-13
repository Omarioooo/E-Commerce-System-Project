package ecommerce_system.ProjectComponents;

@FunctionalInterface
public interface OrderInfoGenerator {
    StringBuilder generateOrderInfo(Cart cart);
}
