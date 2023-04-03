package core;

import java.util.ArrayList;

import core.Animal;

public class AnimalFarm extends Farm {
    private int animalCount;
    private int animalMax;
    private ArrayList<Animal> animals;

    public AnimalFarm(){
        super();
        animalCount = 0;
        animalMax = 5;
    }

    public AnimalFarm(String farmName) {
        super(farmName);
    }

    public void addAnimal(Animal animal) {
        if(animalCount < animalMax) {
            animalCount++;
            animals.add(animal);
        }
    }

    @Override
    public String menuOptions() {
        return "Check on Animals\t(2 hours)\n";
    }

    @Override
    public boolean farmOptions() {
        boolean quit = false;
        
        return false;
    }
}
