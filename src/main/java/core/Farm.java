package core;

import java.util.ArrayList;

public abstract class Farm {
    protected ArrayList<FarmHand> farmHands;
    protected String endMessage;
    protected int funds;
    protected int dayCount;

    public Farm() {
        funds = 6000;
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
