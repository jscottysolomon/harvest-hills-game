package core;

import java.util.ArrayList;

public abstract class Farm {
    protected ArrayList<FarmHand> farmHands;
    protected String farmName;
    protected String endMessage;
    protected int farmerCount;
    protected int funds;
    protected int dayCount;
    protected boolean isDay;

    public Farm() {
        farmName = "Harvest Hills";
        farmerCount = 0;
        funds = 6000;
        isDay = true;
        endMessage = null;
        farmHands = new ArrayList<>();
    }

    public void cycle() {
        System.out.println("Morning " + dayCount + ", Funds: $" + funds);
        executeFarm();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Night " + dayCount + ", Funds: $" + funds);
        goToMarket();

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Farm status");
        System.out.println(toString());
    }

    public int getFunds() {
        return funds;
    }

    public void updateFarm() {
        for(FarmHand helper : farmHands) {
            funds -= helper.getRate();
        }
        dayCount++;
    }
    
    public String endMessage() {
        return endMessage;
    }

    public abstract void goToMarket();

    public abstract String toString();

    public abstract void executeFarm();

    public abstract boolean endGame();
    

}
