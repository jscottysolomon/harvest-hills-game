package core;

import java.util.ArrayList;

// import core.Animal;

public class AnimalFarm extends Farm {
    private int sickAnimalCount;
    private ArrayList<Animal> animals;
    private AnimalMarket animalMarket;

    public AnimalFarm() {
        super();
        sickAnimalCount = 0;
        animals = new ArrayList<Animal>();

        MarketFactory marketFactory = new MarketFactory();
        animalMarket = marketFactory.getAnimalMarke();
    }

    public void addAnimal(ArrayList<Animal> animalList) {
        animals.addAll(animalList);
    }

    @Override
    public void updateFarm() {
        super.updateFarm();

        sickAnimalCount = 0;

        for(Animal animal : animals) {
            animal.update();
            if(animal.isSick()) {
                sickAnimalCount++;
            }
        }
    }

    @Override
    public void executeFarm() {
        System.out.println("Animals on farm: " + animals.size());
        ArrayList<Animal> toRemove = new ArrayList<Animal>();

        for(Animal animal : animals) {
            System.out.print("   ");

            if(animal.isDead()) {
                System.out.println(animal.getName() 
                    + " was attacked by wolves last night! They will be sold for $" 
                    + animal.getSellPrice());
                funds += animal.getSellPrice();
                toRemove.add(animal);
            } else if(animal.isSick()) {
                System.out.println(animal.getName() 
                    + " isn't looking very healthy and won't be able to produce " 
                    + animal.getProductName());
            } else if(animal.productionReady()) {
                System.out.println(animal.getName() 
                    + " produced " + animal.getProductName() + ", which will be sold for $" 
                    + animal.getProductionSellPrice());
                funds += animal.getProductionSellPrice();
            } else if(animal.isMaxAge()) {
                System.out.println(animal.getName() 
                    + " lived a long healthy life and will be sold for $" 
                    + animal.getSellPrice());
                funds += animal.getSellPrice();
                toRemove.add(animal);
            } else{
                System.out.println(animal.getName() + " is looking very happy today.");
            }
        }

        for(int i = 0; i < toRemove.size(); i++) {
            animals.remove(toRemove.get(i));
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

        ret += "\nAnimals: ";

        for(Animal animal : animals) {
            ret += "\n   " + animal.toString();
        }
        
        return ret;
    }

    @Override
    public boolean endGame() {
        if(funds < 0) {
            endMessage = "Your workers refused to work because you have no money...";
        }

        if(sickAnimalCount > (animals.size() / 2)) {
            endMessage = "Over half your animals are sick. No one's going to buy them anymore...";
        }

        if(dayCount > 15) {
            endMessage = "The season has ended.";
        }

        return (endMessage != null);
    }

    @Override
    public void goToMarket() {
        ArrayList<FarmHand> farmers = animalMarket.newFarmHands();

        System.out.println("New Farmers:");
        for(FarmHand helper : farmers) {
            farmHands.add(helper);
            System.out.println("   " + helper.getName() + "\t$" + helper.getRate() + "/day");
        }

        ArrayList<Animal> animalList = animalMarket.getPurchases();

        System.out.println("New Animals");

        for(Animal animal : animalList) {
            animals.add(animal);
            funds -= animal.getPurchasePrice();
            System.out.println("   " + animal.getName() 
                + "(" + animal.getClass().getSimpleName() + ")" 
                + " bought for $" + animal.getPurchasePrice());
        }
    }
}
