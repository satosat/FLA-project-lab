import database.Database;
import model.User;

import java.util.Scanner;

public class Authentication {
    static Scanner scan = new Scanner(System.in);
    public static void start(){
        System.out.println("=================");
        System.out.println("👤 Authentication");
        System.out.println("=================");
        System.out.println("1. Login");
        System.out.println("2. Exit");

        int choice = 0;
        do {
            System.out.print(">> ");
            choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    return;
                case 2:
                    System.exit(0);
                default:
                    System.out.println("No Illegal Access 🤦‍");
                    break;
            }
        } while(choice != 2);
    }
    public static User login() {
        start();
        Database database = Database.getInstance();

        String email;
        String name;
        String phoneNumber;

        System.out.print("Please enter your email >> ");
        email = scan.nextLine();

        User user = database.getUserByEmail(email);

        // If user already exist in database, use the existing user
        if(user != null) {
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
