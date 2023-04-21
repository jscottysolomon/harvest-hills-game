package core;

public class FarmFactory {
    
    FarmFactory() {}

    public Farm getCropFarm() {
        CropFarm farm = new CropFarm();

        return farm;
    }

    public Farm getAnimalFarm() {
        AnimalFarm farm = new AnimalFarm();

        return farm;
    }
}
