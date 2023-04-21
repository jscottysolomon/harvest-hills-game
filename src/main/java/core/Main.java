package core;

import java.lang.Thread;

public class Main{
    public static void main(String[] args) {

        Mediator mediator = new Mediator();

        boolean exit = false;

        mediator.createGame();

        while(!exit){
            mediator.cycle();

            if(mediator.endGame()) {
                exit = true;
            } else {
                try {
                    Thread.sleep(5000);
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }    
}