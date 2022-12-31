import builder.CarBuilder;
import database.Database;
import model.car.Car;
import model.car.Engine;
import model.car.Wheel;
import model.car.seat.Seat;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    Scanner scan = new Scanner(System.in);

    Main(){
        selectAccount();
    }

    private void selectAccount() {
        int choice = 0;
        do{
            System.out.println("===========================");
            System.out.println("Choose Account:");
            System.out.println("1. Client");
            System.out.println("2. Admin");
            System.out.println("0. Exit");
            System.out.print(">> ");
            choice = scan.nextInt();
            scan.nextLine();
            switch(choice){
                case 1:
                    clientMenu();
                    break;
                case 2:
                    adminMenu();
                    break;
                case 3:
                    System.exit(0);
            }
        }while(choice < 1 || choice > 2);
    }

    private void adminMenu() {
        // Add Car
        // Remove Car
        // View All Cars

    }

    private void clientMenu() {
        System.out.println("=========================");
        System.out.println("Welcome to Go-Car Car Lot");
        System.out.println("=========================");
        System.out.println("1. Buy a car");
        System.out.println("2. View all cars");

        int choice = 0;
        do{
            System.out.print(">> ");
            choice = scan.nextInt();
            scan.nextLine();
            switch (choice){
                case 1:
                    buyCar();
                    break;
                case 2:
                    viewAllCars();
            }
        }while(choice != 0);
    }

    private ArrayList<Car> viewAllCars() {
        Database database = Database.getInstance();
        ArrayList<Car> cars = database.getCars();
        System.out.println("=====================");
        System.out.println("Go-Car Available Cars");
        System.out.println("=====================");
        int index = 1;
        for (Car car : cars) {
            System.out.println(index++ + ". " + car.getName());
        }
        System.out.println("=====================");
        System.out.println("");
        return cars;
    }

    private void buyCar() {
        ArrayList<Car> cars = viewAllCars();
        CarBuilder carBuilder = new CarBuilder();

        // Builder Design Pattern is used here

        // 1. Choose Car Frame
        int carChoiceIndex = Prompt.carChoiceIndex(cars.size());
        carBuilder.setName(cars.get(carChoiceIndex).getName());

        // 2. Choose Color
        String color = Prompt.carColor();
        carBuilder.setColor(color);

        // 3. Choose Engine
        Engine engine = Prompt.carEngine();
        carBuilder.setEngine(engine);

        // 4. Choose Wheel
        Wheel wheel = Prompt.carWheel();
        carBuilder.setWheel(wheel);


        // 5. Choose Seat
//        Seat seat = Prompt.carSeat();
//        carBuilder.setSeat(seat);

        Car car = carBuilder.build();
        Database database = Database.getInstance();

        // Add User, Create new user if not registered

        // Add Car bought to the user's Car List
    }

    public static void main(String[] args) {
        new Main();
    }
}