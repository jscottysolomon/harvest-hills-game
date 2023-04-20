package core;

import java.util.ArrayList;
import java.util.Random;

public class AnimalMarket extends Market<Animal> {

    String[] cowNames = {"Bessie", "Daisy", "Buttercup", "Maggie", "Molly", "Rosie", 
        "Lily", "Sadie", "Ginger", "Fiona", "Elsie", "Abby", "Bella", "Bianca", 
        "Coco", "Delilah", "Eva", "Flora", "Giselle", "Harper", "Ivy", "Jasmine", 
        "Kiki", "Luna", "Mia", "Nala", "Olive", "Penny", "Queenie", "Ruby", "Stella", 
        "Tessa", "Uma", "Violet", "Willow", "Xena", "Yara", "Zara"};

    String[] chickenNames = {"Henny", "Penny", "Rosie", "Dolly", "Sunny", "Peep", 
        "Chirpy", "Fluffy", "Lucky", "Nugget", "Poppy", "Buddy", "Babs", "Pippin", "Ruby", 
        "Scooter", "Ginger", "Lola", "Roo", "Tweetie", "Winnie", "Ziggy", "Chickpea", "Pepper", 
        "Puddles", "Quackers", "Rainbow", "Snowy", "Star", "Tilly", "Twinkle"};

    String[] sheepNames = {"Baaarbara", "Lambert", "Wooly", "Fleece", "Bubbles", "Cotton", 
        "Luna", "Misty", "Onyx", "Pearl", "Ramses", "Shaun", "Shirley", "Baaarnaby", "Daisy", 
        "Ewe-nique", "Graze", "Lambchop", "Lulu", "Marsha", "Minnie", "Ralph", "Sheepy", "Wendy", 
        "Willow", "Wooliam", "Woolyanna", "Ziggy"};

    public AnimalMarket() {
        super();
    }

    @Override
    public ArrayList<Animal> getPurchases() {
        ArrayList<Animal> animals = new ArrayList<>();
        int newAnimals = rand.nextInt(5);

        for(int i = 0; i < newAnimals; i++) {
            int animalType = rand.nextInt(2);
            
            if(animalType == 0) {
                int purchasePrice = rand.nextInt(800) + 453;
                int index = rand.nextInt(sheepNames.length);

                Sheep sheep = new Sheep(sheepNames[index], purchasePrice);
                animals.add(sheep);
            } else if(animalType == 1) {
                int purchasePrice = rand.nextInt(400) + 133;
                int index = rand.nextInt(chickenNames.length);

                Chicken chicken = new Chicken(chickenNames[index], purchasePrice);
                animals.add(chicken);
            } else {
                int purchasePrice = rand.nextInt(900) + 386;
                int index = rand.nextInt(cowNames.length);

                Cow cow = new Cow(cowNames[index], purchasePrice);
                animals.add(cow);
            }
        }

        return animals;
    }


}
