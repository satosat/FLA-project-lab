import database.Database;
import factory.FabricSeatCreator;
import factory.LeatherSeatCreator;
import factory.SeatCreator;
import model.User;
import model.car.Engine;
import model.car.Wheel;
import model.car.seat.Seat;

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
        System.out.println("********************");
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

    public static Seat carSeat(){
        System.out.println("********************");
        System.out.println("Available Car Seats💺");
        System.out.println("********************");
        System.out.println("1. Fabric Seat");
        System.out.println("2. Leather Seat");

        int seatChoice = 0;
        SeatCreator seatCreator = null;
        do{
            System.out.print("Choose Wheel Size (inch) [1 - 2] >> ");
            seatChoice = scan.nextInt();
            scan.nextLine();
        }while(seatChoice < 1 || seatChoice > 2);

        switch(seatChoice){
            case 1:
                seatCreator = new FabricSeatCreator();
                break;
            case 2:
                seatCreator = new LeatherSeatCreator();
                break;
        }
        return seatCreator.useSeat();
    }

    public static boolean carAirFreshener(){
        String choice = "N";
        do{
            System.out.print("Would you like to add air freshener to your car? [Y/N] >> ");
            choice = scan.nextLine();
        }while(!(choice.equalsIgnoreCase("N")||choice.equalsIgnoreCase("Y")));

        if(choice.equalsIgnoreCase("Y")){
            return true;
        }
        return false;
    }

    public static boolean carSunRoof(){
        String choice = "N";
        do{
            System.out.print("Would you like to add sun roof to your car? [Y/N] >> ");
            choice = scan.nextLine();
        }while(!(choice.equalsIgnoreCase("N")||choice.equalsIgnoreCase("Y")));

        if(choice.equalsIgnoreCase("Y")){
            return true;
        }
        return false;
    }

    public static boolean carInfotainmentUpgrade(){
        String choice = "N";
        do{
            System.out.print("Would you like to add Android Auto & Apple Car Play to your car? [Y/N] >> ");
            choice = scan.nextLine();
        }while(!(choice.equalsIgnoreCase("N")||choice.equalsIgnoreCase("Y")));

        if(choice.equalsIgnoreCase("Y")){
            return true;
        }
        return false;
    }

    public static User getClient(){
        Database database = Database.getInstance();

        String email;
        String name;
        String phoneNumber;

        System.out.print("Please enter your email >> ");
        email = scan.nextLine();

        User user = database.getUserByEmail(email);
        // If user already exist in database, use the existing user
        if(user != null){
            System.out.println("Welcome back! " + user.getName());
            return user;
        }

        System.out.print("Please enter your name >> ");
        name = scan.nextLine();

        System.out.print("Please enter your phone number >> ");
        phoneNumber = scan.nextLine();

        user = new User(name, email, phoneNumber, false);

        database.addUser(user);
        System.out.println("Registration successful! Welcome " + name);

        return user;
    }
}
