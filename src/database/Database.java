package database;

import model.User;
import model.car.Car;
import model.car.Engine;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Database {
    private static Database instance;
    private static ArrayList<Car> cars;
    private static ArrayList<User> users;
    private static ArrayList<Engine> engines;
    private static Map<User, ArrayList<Car>> sales;

    private Database() {
        cars = new ArrayList<>();
        users = new ArrayList<>();
        engines = new ArrayList<>();
        sales = new HashMap<>();
        seed();
    }

    private void seed() {
        // Engines
        engines.add(new Engine(90, 1.3, 4, "V"));
        engines.add(new Engine(110, 1.5, 4, "V"));
        engines.add(new Engine(110, 1.5, 4, "V"));
        engines.add(new Engine(140, 1.6, 4, "V"));
        engines.add(new Engine(200, 2.0, 6, "V"));

        // Cars
        cars.add(new Car("Alpha (Sedan)"));
        cars.add(new Car("Beta (SUV)"));
        cars.add(new Car("Omega (Hatchback)"));

        // User & Admin
        users.add(new User("User", "user@mail.com", "085100200300", false));
        users.add(new User("Admin", "admin@mail.com", "085100200400", true));
    }

    public static Database getInstance(){
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public static ArrayList<Engine> getEngines() {
        return engines;
    }

    public static void setEngines(ArrayList<Engine> engines) {
        Database.engines = engines;
    }

    public User getUserByEmail(String email){
        ArrayList<User> users = getUsers();
        for (User user : users) {
            if(user.getEmail().equalsIgnoreCase(email)){
                return user;
            }
        }
        return null;
    }
    public void deleteCarByIndex(int index){
        cars.remove(index);
    }
    public void addUser(User user) {
        users.add(user);
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void displayAllEngines()
    {
        int index = 1;
        System.out.println("********************");
        System.out.println("Available Engines ⚙");
        System.out.println("********************");
        for (Engine engineOption : engines) {
            System.out.println(index++ + ". " + engineOption.getSpecification());
        }
    }

    public ArrayList<Car> getTransactions(User user)
    {
        return sales.get(user);
    }

    public void addTransaction(User user, Car newCar)
    {
        if(sales.get(user) != null) {
            sales.get(user).add(newCar);
        } else {
            sales.put(user, new ArrayList<Car>() {
                {
                    add(newCar);
                }
            });
        }
    }
}
