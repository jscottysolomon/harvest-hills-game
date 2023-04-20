package core;

import java.util.Random;

/**
 * Represents an Animal for the Animal Farm.
 */
public abstract class Animal {
    protected final int MAXIMUM_AGE = 14;
    protected String name;
    protected String productName;
    protected String animalType;
    protected int age;
    protected int sellPrice;
    protected boolean isSick;
    protected boolean isDead;
    protected boolean productionReady;
    protected int productionSellPrice;
    protected int purchasePrice;
    private int productionDays;

    /**
     * Basic constructor for animal 
     * 
     * @param name : Animal's name
     * @param purchasePrice : Price animal was purchased for
     */
    public Animal(String name, int purchasePrice) {
        this.name = name;
        this.purchasePrice = purchasePrice;
        isSick = false;
        age = 1;
        productionReady = false;
        isDead = false;
        productionDays = 0;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public void updateAge() {
        age++;
    }

    public String getProductName() {
        return productName;
    }

    public int getAge() {
        return age;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public boolean isSick() {
        return isSick;
    }

    public boolean isDead() {
        return isDead;
    }

    public boolean productionReady() {
        return productionReady;
    }

    public String getName() {
        return name;
    }

    public boolean isMaxAge() {
        return (age >= MAXIMUM_AGE);
    }

    public int getProductionSellPrice() {
        return productionSellPrice;
    }


    /**
     * Used when the farm is updated in the main game loop.
     * Updated if an animal is sick, days it's been alived, if
     * it was killed, sell price, et cetera.
     */
    public void update() {
        age++;

        productionReady = (age > 2 && (productionDays++ % 2 == 0) && !isSick);

        Random random = new Random();

        int randomNum = random.nextInt();
        randomNum = randomNum % 20;
        isSick = (randomNum < 3);

        if(!isSick) {
            sellPrice += random.nextInt(purchasePrice / 3);
        } else {
            sellPrice -= random.nextInt(purchasePrice / 15);
            isSick = (random.nextInt(4) > 1);
        }        

        int wolfAttack = random.nextInt(10);

        if(wolfAttack < 2) {
            isDead = false;
            sellPrice = random.nextInt(300);
        }
    }

    public String toString() {
        return (name + " (" + this.getClass().getSimpleName() 
            + ")   \tsell Price of $" + sellPrice + "\tis sick: " 
            + isSick  + "\t" + age + " day(s) old");
    }
}
