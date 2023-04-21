package core;

import java.util.ArrayList;

public class CropFarm extends Farm{
    private CropMarket cropMarket;
    private ArrayList<Crop> cropList;
    int deadCrops;

    public CropFarm() {
        super();
        cropList = new ArrayList<>();

        MarketFactory marketFactory = new MarketFactory();
        cropMarket = marketFactory.getCropMarket();
        
        deadCrops = 0;
    }

    @Override
    public void goToMarket() {
        ArrayList<FarmHand> farmers =  cropMarket.newFarmHands();

        System.out.println("New Farmers:");
        for(FarmHand helper : farmers) {
            farmHands.add(helper);
            System.out.println("   " + helper.getName() + "\t$" + helper.getRate() + "/day");
        }

        ArrayList<Crop> marketCrops = cropMarket.getPurchases();

        System.out.println("New Crops:");

        for(Crop crop : marketCrops) {
            cropList.add(crop);
            funds -= crop.getPurchasePrice();
            System.out.println("   " + crop.getClass().getSimpleName() + " seed for $" 
                + crop.getPurchasePrice());
        }
    }

    @Override
    public String toString() {
        String ret = "";

        ret += "Funds: $" + funds;
        ret += "\nFarmHands: ";

        for (FarmHand farmer : farmHands) {
            ret += "\n   " + farmer.toString();
        }

        ret += "\nCrops: ";

        for(Crop crop : cropList) {
            ret += "\n   " + crop.toString();
        }
        
        return ret;
    }

    @Override
    public void executeFarm() {
        System.out.println("Crops on farm: " + cropList.size());

        ArrayList<Crop> toRemove = new ArrayList<Crop>();


        for(Crop crop : cropList) {
            System.out.print("   " + crop.getClass().getSimpleName() + " ");

            if(crop.isDestroyed()) {
                System.out.println("was eaten by a rabbit");
                toRemove.add(crop);
            } else if(crop.fullyGrown()) {
                System.out.println("is fuly grown and will be sold for $" + crop.getSellPrice());
                funds += crop.getSellPrice();
                toRemove.add(crop);
            } else {
                System.out.println("will be ready in " + crop.daysTillGrown() + " day(s)");
            }
        }

        for(Crop crop : toRemove) {
            cropList.remove(crop);
        }
    }

    @Override
    public void updateFarm() {
        super.updateFarm();

        deadCrops = 0;
        
        for(Crop crop : cropList) {
            crop.update();
            if(crop.isDestroyed()) {
                deadCrops++;
            }
        }
    }

    @Override
    public boolean endGame() {
        if(funds < 0) {
            endMessage = "Your workers refused to work because you have no money...";
        } else if(deadCrops == cropList.size() && cropList.size() != 0) {
            endMessage = "Most of you crops are dead";
        } else if(funds > 8000) {
            endMessage = "Your workers felt overworked and underpaid. They unionized against you...";
        } 
        else if(dayCount > 10) {
            endMessage = "The season has ended.";
        }

        return (endMessage != null);
    }
    
}
