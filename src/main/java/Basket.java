import java.util.*;

public class Basket {
    private Map<String, Integer> productsInBasket = new HashMap<>();
    // мапа <Код продукта, цена>

    public Map<String, Integer> getProductsInBasket() {
        return productsInBasket;
    }

    public void addProduct(String code) {
        if (ShopUtils.getProductByCode(code) == null) {
            System.out.println("Неизвестный код товара");
        } else {
            productsInBasket.merge(code, 1, Integer::sum);
        }
    }

    public void deleteProduct(String code) {
        Integer productsCount = productsInBasket.get(code);
        if (productsCount == null) {
            System.out.println("В корзине нет товаров с кодом '" + code + "'");
        } else if (productsCount == 1) {
            productsInBasket.remove(code);
        } else {
            productsInBasket.put(code, productsCount - 1);
        }
    }
}
