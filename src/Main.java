import builder.CarBuilder;
import database.Database;
import model.User;
import model.car.Car;
import model.car.Engine;
import model.car.Wheel;
import model.car.seat.Seat;
import observable.Promo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    Scanner scan = new Scanner(System.in);
    private User currentUser = null;

    public Main(){
        start();
    }

    private void start() {

        do {
            currentUser = Authentication.login();
            if(currentUser.isAdmin()){
                adminMenu();
            }else{
                clientMenu();
            }
            currentUser = null;
        } while(true);

    }

    private void adminMenu() {
        while(true) {
            System.out.println("======================");
            System.out.println("Go-Car Admin");
            System.out.println("======================");
            System.out.println("1. Add Car\n" +
                    "2. Remove Car\n" +
                    "3. View All Car\n" +
                    "4. Push Promo\n" +
                    "5. Logout");

            int choice = 0;
            choice = scan.nextInt();
            scan.nextLine();

            switch(choice){
                case 1:
                    addCar();
                    break;
                case 2:
                    removeCar();
                    break;
                case 3:
                    viewAllCars();
                    break;
                case 4:
                    pushPromo();
                    break;
                case 5:
                    return;
            }
        }
    }

    private void pushPromo() {
        String message;
        System.out.println("Enter the promo message: ");
        message = scan.nextLine();

        Promo.notifyUsers(message);
    }

    private void addCar(){
        Database database = Database.getInstance();

        String name;
        do {
            System.out.print("Insert Car Name : ");
            name = scan.nextLine();
        } while(name.length() == 0);

        database.addCar(new Car(name));
    }

    private void removeCar(){
        Database database = Database.getInstance();
        viewAllCars();
        int choice = 0;
        do{
            System.out.print("Choose which car to remove >> ");
            choice = scan.nextInt();
            scan.nextLine();
        }while(choice < 1 || choice > database.getCars().size());
        database.deleteCarByIndex(choice - 1);

        System.out.println("Car successfully deleted!");
    }

    private void clientMenu() {
        currentUser.showPromos();
        int choice = 0;
        do{
            System.out.println("=========================");
            System.out.println("Welcome to Go-Car Car Lot");
            System.out.println("=========================");
            System.out.println("1. Buy a car");
            System.out.println("2. View all cars");
            System.out.println("3. My Transactions");
            System.out.println("4. Logout");
            System.out.print(">> ");

            choice = scan.nextInt();
            scan.nextLine();

            switch (choice){
                case 1:
                    buyCar();
                    break;
                case 2:
                    viewAllCars();
                    break;
                case 3:
                    viewTransactions();
                    break;
                case 4:
                    return;
            }
        }while(true);
    }

    private void viewAllCars() {
        Database database = Database.getInstance();
        ArrayList<Car> cars = database.getCars();

        System.out.println("=====================");
        System.out.println("Go-Car Available Cars");
        System.out.println("=====================");

        int index = 1;
        for (Car car : cars) {
            System.out.println(index++ + ". " + car.getName());
        }
        System.out.println("=====================\n");
    }
    private void viewTransactions(){
        ArrayList<Car> boughtCars = Database.getInstance().getTransactions(currentUser);
        System.out.println("==============================");
        System.out.println("🚗💸 Recent Transactions 💸🚗");
        System.out.println("==============================");

        int index = 1;
        for (Car car : boughtCars) {
            System.out.println(index++ + ". "+ car.toString());
        }

        System.out.println("==============================");
    }

    private void buyCar() {
        viewAllCars();
        ArrayList<Car> cars = Database.getInstance().getCars();
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
        Seat seat = Prompt.carSeat();
        carBuilder.setSeat(seat);

        // 6. [OPTIONAL] Air Freshener
        carBuilder.setAirFreshener(Prompt.carAirFreshener());

        // 7. [OPTIONAL] Sun Roof
        carBuilder.setSunRoof(Prompt.carSunRoof());

        // 8. [OPTIONAL] Android Auto & Apple Car Play
        carBuilder.setInfotainmentUpgrade(Prompt.carInfotainmentUpgrade());

        // Add Car bought to the user's Car List
        Car car = carBuilder.build();
        currentUser.addBoughtCars(car);
    }

    public static void main(String[] args) {
        new Main();
    }
}