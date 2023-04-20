package core;

public class FarmHand {
    String name;
    int rate;

    public FarmHand(String name, int rate) {
        this.name = name;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public int getRate() {
        return rate;
    }

    public String toString() {
        return (name + ", rate $" + rate + "/day");
    }
}
