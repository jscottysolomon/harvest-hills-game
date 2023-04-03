package core;

public abstract class Animal {
    private int MAX_AGE = 14;
    private String name;
    private int age;
    private boolean sick;

    public Animal(String name) {
        this.name = name;
    }

    public void updateAge(){
        age++;
    }

    public abstract int getSellPrice();
}
