package core;

public class FarmFactory {
    
    FarmFactory() {}

    public Farm getCropFarm() {
        return null;
    }

    public Farm getAnimalFarm() {
        AnimalFarm farm = new AnimalFarm();

        return farm;
    }
}
