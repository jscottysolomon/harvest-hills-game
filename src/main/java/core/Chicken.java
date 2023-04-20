package core;

public class Chicken extends Animal {

    public Chicken(String name, int purchasePrice) {
        super(name,purchasePrice);
        productName = "eggs";
        productionSellPrice = 70;
        sellPrice = 40;
    }
}
