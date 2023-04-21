package core;

public class MarketFactory {
    
    public MarketFactory() {
    }

    public AnimalMarket getAnimalMarke() {
        AnimalMarket market = new AnimalMarket();
        return market;
    }

    public CropMarket getCropMarket() {
        CropMarket market = new CropMarket();

        return market;
    }


}
