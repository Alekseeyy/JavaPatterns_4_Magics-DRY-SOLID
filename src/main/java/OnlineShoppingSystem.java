import products.*;

public class OnlineShoppingSystem implements CheckCounterService, MailDeliveryService {
    private final static double CLOTHES_FRACTION_OF_STARTING_PRICE = 0.9;
    private final static int DELIVERY_COST = 1000;

    @Override
    public int getTotalSum(Basket basket) {
        int productsSum = basket.getProductsInBasket().entrySet().stream().mapToInt(entry -> {
            String code = entry.getKey();
            Product product = ShopUtils.getProductByCode(code);
            int count = entry.getValue();
            int finalPrice;
            if (product instanceof Clothes) {
                finalPrice = (int) (product.getPrice() * CLOTHES_FRACTION_OF_STARTING_PRICE);
            } else {
                finalPrice = product.getPrice();
            }
            return finalPrice * count;
        }).sum();

        return productsSum == 0 ? 0 : productsSum + DELIVERY_COST;
    }

    @Override
    public void sendMails() {
        //Здесь должна быть какая-то более сложная логика
        ShopUtils.printAllProducts();
    }
}
