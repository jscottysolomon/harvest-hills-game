package core;

public class Sheep extends Animal {
    
    public Sheep(String name, int purchasePrice) {
        super(name,purchasePrice);
        productName = "wool";
        productionSellPrice = 250;
        sellPrice = 430;
    }
}
