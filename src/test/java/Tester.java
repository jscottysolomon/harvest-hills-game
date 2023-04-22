import static org.junit.Assert.assertEquals;

import org.junit.Test;

import core.*;

public class Tester {

    @Test
    public void animalFarm() {
        AnimalFarm farm = new AnimalFarm();

        assertEquals(farm.getFunds(),6000);
        assertEquals(farm.endMessage(), null);
        assertEquals(farm.endGame(),false);
    }

    @Test
    public void cropFarm() {
        CropFarm farm = new CropFarm();

        assertEquals(farm.getFunds(),6000);
        assertEquals(farm.endMessage(), null);
        assertEquals(farm.endGame(),false);
    }

    @Test
    public void animalUpdate() {

        Cow cow = new Cow("Betsy", 90);

        assertEquals("Betsy",cow.getName());
        assertEquals(cow.getAge(),1);

        for(int i = 2; i < 16; i++) {
            int temp_price = cow.getSellPrice();
            cow.update();
            assertEquals(i, cow.getAge());

            if(cow.isSick()) {
                assert(temp_price >= cow.getSellPrice());
            }
        }
        assert(cow.isMaxAge());
        assert(cow.getSellPrice() > cow.getPurchasePrice());
    }

    @Test
    public void cropUpdate() {
        Pumpkin pumpkin = new Pumpkin(30,50);

        for(int i = 0; i < 5; i++) {
            if(pumpkin.isDestroyed()) {
                assert(!pumpkin.fullyGrown());
            }

            if(pumpkin.fullyGrown()) {
                assert(!pumpkin.isDestroyed());
            }
        }
    }

    @Test
    public void exitConditions() {
        AnimalFarm farm = new AnimalFarm();
        for(int i = 0; i < 20; i++) {
            farm.cycle();
            if(farm.getFunds() <= 0) {
                assert(farm.endGame());
            }

            if(i >= 15) {
                assert(farm.endGame());
            }
        }
    }

    
}
