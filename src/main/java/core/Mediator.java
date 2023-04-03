package core;

public class Mediator {
    private int dayCount;
    private boolean day;
    private int time;
    private Farm farm;

    public Mediator() {
        dayCount = 0;
        time = 6;
        day = true;
        farm = null;
    }

    public void updateGame() {

    }

    public void createGame() {
        farm = new AnimalFarm();
    }

    public void handleInput(String s){
        int option = -1;

        try{
            option = Integer.parseInt(s);
        } catch(Exception e){
            System.out.println("Invalid input!\n");
        }

        if(option == 2){
            if(day){
                time = 14;
                day = false;
            }
            else {
                newDay();
            }
        }
          
    }

    public String menuOptions() {
        String ret = "";
        ret += "Time: " + time + "\tDay: " + dayCount + "\n";
        ret += "Options: \n";
        ret += "1 - Go to Town Supplier (2 hours)\n";

        if(day) { 
            ret += "2 - Take a nap (Wake at 2 p.m)\n";
        } else {
            ret += "2 - Go to bed (Wake at 6 am)\n";
        }

        if(farm != null){
            ret += "3 - " + farm.menuOptions();
        }

        ret += "\n";

        return ret;
    }

    private void newDay() {
        time = 6;
        dayCount++;
        day = true;
    }
}
