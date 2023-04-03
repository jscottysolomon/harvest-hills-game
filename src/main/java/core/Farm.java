package core;

public abstract class Farm {
    private String farmName;
    private int farmerCount;
    private int funds;
    private int upgradeCount;
    private final int MAX_FARMERS = 10;

    public Farm() {
        farmName = "Harvest Hills";
        farmerCount = 0;
        funds = 0;
        upgradeCount = 0;
    }

    public Farm(String farmName) {
        this.farmName = farmName;
        farmerCount = 0;
        funds = 0;
        upgradeCount = 0;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public void increaseFunds(int funds){
        this.funds += funds;
    }

    public abstract String menuOptions();
    public abstract boolean farmOptions();

}
