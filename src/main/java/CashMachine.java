import products.Product;

public class CashMachine implements CheckCounterService {

    @Override
    public int getTotalSum(Basket basket) {
        return basket.getProductsInBasket().entrySet().stream().mapToInt(entry -> {
            String code = entry.getKey();
            Product product = ShopUtils.getProductByCode(code);
            int count = entry.getValue();
            return product.getPrice() * count;
        }).sum();
    }
}
