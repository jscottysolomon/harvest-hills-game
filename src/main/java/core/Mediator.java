package core;

public class Mediator {
    private Farm farm;
    private Market<Animal> market;

    public Mediator() {}

    public void cycle() {
        System.out.println("***********************");
        farm.updateFarm();
        farm.cycle();
        System.out.println("***********************");
        
    }

    public void createGame() {
        farm = new AnimalFarm();
        market = new AnimalMarket();
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
