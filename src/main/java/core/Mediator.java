package core;

public class Mediator {
    private Farm farm;

    public Mediator() {}

    public void cycle() {
        System.out.println("***********************");
        farm.updateFarm();
        farm.cycle();
        System.out.println("***********************");
        
    }

    public void createGame() {
        long currentTimeMillis = System.currentTimeMillis();
        FarmFactory farmFactory = new FarmFactory();
        
        if(currentTimeMillis % 2 == 0) {
            farm = farmFactory.getAnimalFarm();
            System.out.println("Starting animal farm!");
        } else {
            farm = farmFactory.getCropFarm();
            System.out.println("Starting crop farm!");
        }
    }

    public boolean endGame() {
        if(farm.endGame()) {
            System.out.println(farm.endMessage());
            return true;
        } else {
            return false;
        }
    }
}
