package core;

public class Cow extends Animal {

    public Cow(String name, int purchasePrice) {
        super(name,purchasePrice);
        productName = "milk";
        productionSellPrice = 150;
        sellPrice = 270;
    }
}
