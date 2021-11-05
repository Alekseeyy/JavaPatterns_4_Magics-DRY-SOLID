package products;

public class HouseholdChemicals extends Product {
    private final boolean isToxis;

    public HouseholdChemicals(String name, int price, boolean isToxis) {
        super(name, price);
        this.isToxis = isToxis;
    }

    @Override
    public String toString() {
        return super.toString() + "; isToxis = " + isToxis;
    }
}
