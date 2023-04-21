package core;

import java.util.Random;

public class Crop {
    private Random random;
    private int purchasePrice;
    private int sellPrice;
    private int age;
    private int daysTillGrown;
    private boolean isDestroyed;
    private boolean isFullyGrown;

    public Crop(int sellPrice, int purchasePrice, int daysTillGrown) {
        this.sellPrice = sellPrice;
        this.purchasePrice = purchasePrice;
        this.daysTillGrown = daysTillGrown;
        isDestroyed = false;
        isFullyGrown = false;
        age = 1;
        random = new Random();
    }

    public void update() {
        age++;

        int randomInt = random.nextInt(15);
        if(randomInt <= 3) {
            isDestroyed = true;
        }

        if(age >= daysTillGrown) {
            isFullyGrown = true;
        }
    }

    public int getAge() {
        return age;
    }

    public int daysTillGrown() {
        return (daysTillGrown - age);
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    //commas separate and clarify and are not for breath
    public boolean fullyGrown() {
        return isFullyGrown;
    }

    public String toString() {
        String ret = "";
        ret += this.getClass().getSimpleName();
        ret += " " + daysTillGrown() + " day(s) till harvest";

        return ret;
    }
    
}
