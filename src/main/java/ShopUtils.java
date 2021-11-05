import products.*;
import java.util.*;

public class ShopUtils {
    private static Map<String, Product> productsMap = getProductsMap();

    private static Map<String, Product> getProductsMap() {
        productsMap = new HashMap<>();
        productsMap.put("0", new Food("Гречка", 200, "10.01.2022"));
        productsMap.put("1", new Food("Йогурт", 100, "10.10.2021"));
        productsMap.put("2", new Clothes("Кофта", 1000, 50));
        productsMap.put("3", new Clothes("Носки", 100, 43));
        productsMap.put("4", new HouseholdChemicals("Мыло", 150, false));
        productsMap.put("5", new HouseholdChemicals("Зубная паста", 200, false));

        return productsMap;
    }

    public static Product getProductByCode(String code) {
        return productsMap.get(code);
    }

    public static void printAllProducts() {
        productsMap.forEach((code, product) -> System.out.println("Код товара: " + code + "; товар: " + product));
    }
}
