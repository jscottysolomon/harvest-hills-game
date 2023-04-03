package core;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        System.out.println("Testing setup...!");
        Mediator mediator = new Mediator();

        boolean exit = false;
        Scanner scan = new Scanner(System.in, "UTF-8");
        String input = null;

        mediator.createGame();

        while(!exit){

            mediator.updateGame();
            System.out.println(mediator.menuOptions());

            try{
                input = scan.nextLine();
            } catch(NoSuchElementException e) {
                System.out.println("error\n");
                exit = true;
            }

            if(input.equalsIgnoreCase("QUIT") || input.equalsIgnoreCase("EXIT")) {
                exit = true;
            }

            mediator.handleInput(input);

        }

        scan.close();
    }    
}