package products;

public class Clothes extends Product {
    private final int size;

    public Clothes(String name, int price, int size) {
        super(name, price);
        this.size = size;
    }

    @Override
    public String toString() {
        return super.toString() + "; size = " + size;
    }
}
