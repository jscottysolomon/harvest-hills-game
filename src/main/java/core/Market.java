package core;

import java.util.ArrayList;
import java.util.Random;

/**
 * Acts as a random factory that gives a list of farmHands to be
 * added to farm. Subclasses will also add getPurchases(), which
 * will return a list of things purchased (seeds, animals).
 */
public abstract class Market<Purchase> {
    Random rand;

    public Market() {
        rand = new Random();
    }

    protected String[] helpers = {"Alexander", "Javier", "Jacob", "Emma", "Chloe", "Krobus", 
        "Liam", "Sophia", "Benjamin", "Avery", "Gabriel", "Madison", "Evelyn", "Elijah", 
        "Aurora", "Elena", "Logan", "Aiden", "Brooklyn", "Levi", "Aria", "Aubrey", "Grace", 
        "Natalie", "Caleb", "Victoria", "Audrey", "Hazel", "Jackson", "Nora", "Isabelle", 
        "Riley", "Lila", "Amelia", "Penelope", "Samantha", "Maya", "Caroline", "Lucas", "Owen", 
        "Miles", "Isaac", "Ellie", "Scarlett", "Sofia", "Lila", "Maxwell", "Zachary", "Rebecca"};

    public abstract ArrayList<Purchase> getPurchases();

    /**
     * Acts as a FarmHand factory, but gives a list of farm hands 
     * that will be aded to the main list of farm hands.
     * 
     * @return : List of new farmers to be added to farm
     */
    public ArrayList<FarmHand> newFarmHands() {
        ArrayList<FarmHand> helperList = new ArrayList<>();

        int newFarmHands = rand.nextInt(3);

        for(int i = 0; i < newFarmHands; i++) {
            int index = rand.nextInt(helpers.length);
            int pay = rand.nextInt(300) + 150;
            helperList.add(new FarmHand(helpers[index],pay));
        }

        return helperList;
    }
    
}
