package products;

public class Food extends Product {
    private final String expirationDate;
    // Мы только печатаем срок годности, поэтому для простоты будет тип String

    public Food(String name, int price, String expirationDate) {
        super(name, price);
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return super.toString() + "; expirationDate = " + expirationDate;
    }
}
