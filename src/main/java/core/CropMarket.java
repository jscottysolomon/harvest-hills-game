package core;

import java.util.ArrayList;
import java.util.Random;

public class CropMarket extends Market<Crop>{
Random random; 

    public CropMarket() {
        random = new Random();
    }

    @Override
    public ArrayList<Crop> getPurchases() {
        ArrayList<Crop> crops = new ArrayList<>();
        int newCropNum = random.nextInt(5);

        for(int i = 0; i < newCropNum; i++) {
            int cropType = random.nextInt(2);
            if(cropType == 1) {
                int purchasePrice = random.nextInt(30) + 40;
                int sellPrice = random.nextInt(90) + 132;
                crops.add(new Eggplant(sellPrice, purchasePrice));
            } else if(cropType == 2) {
                int purchasePrice = random.nextInt(40) + 50;
                int sellPrice = random.nextInt(152) + 237;
                crops.add(new Starfruit(sellPrice, purchasePrice));
            } else {
                int purchasePrice = random.nextInt(50) + 60;
                int sellPrice = random.nextInt(189) + 287;
                crops.add(new Pumpkin(sellPrice, purchasePrice));
            }
        }

        return crops;
    }
    
}
