import database.Database;
import model.car.Engine;
import model.car.Wheel;

import java.util.ArrayList;
import java.util.Scanner;

public class Prompt {
    static Scanner scan = new Scanner(System.in);
    public static int carChoiceIndex(int carListLength){
        int choice = 0;
        do{
            System.out.print("Choose car base [1 - " + carListLength + "] >> ");
            choice = scan.nextInt();
            scan.nextLine();
        }while(choice < 1 || choice > carListLength);
        return choice - 1;
    }

    public static String carColor(){
        String color = "Black";
        do{
            System.out.print("Choose car color [Red | Black(Default) | Grey | White] >> ");
            color = scan.nextLine();
        }while(!(color.equals("Red") || color.equals("Black") || color.equals("Grey") || color.equals("White")));
        return color;
    }

    public static Engine carEngine(){
        Engine engine = null;
        int index = 1;

        Database database = Database.getInstance();
        ArrayList<Engine> engines = database.getEngines();
        System.out.println("********************");
        System.out.println("Available Engines ⚙");
        for (Engine engineOption : engines) {
            System.out.println(index++ + ". " + engineOption.getSpecification());
        }

        int choice = 0;
        do{
            System.out.print("Choose engine configuration [1 - " + engines.size() + "] >> ");
            choice = scan.nextInt();
            scan.nextLine();
        }while(choice < 1 || choice > engines.size());

        // Prototype Design Pattern is used here
        // > Cloning an engine preset by the system
        engine = (Engine) engines.get(choice - 1).createClone();
        return engine;
    }
    public static Wheel carWheel(){
        Wheel wheel = null;
        int wheelSize = 0;
        do{
            System.out.print("Choose Wheel Size (inch) [16\" - 20\"] >> ");
            wheelSize = scan.nextInt();
            scan.nextLine();
        }while(wheelSize < 16 || wheelSize > 20);
        wheel = new Wheel(wheelSize);
        return wheel;
    }
}
