package database;

import model.User;
import model.car.Car;
import model.car.Engine;

import java.util.ArrayList;

public class Database implements IDatabase {
    private static Database instance;
    private static ArrayList<Car> cars;
    private static ArrayList<User> users;
    private static ArrayList<Engine> engines;

    private Database() {
        cars = new ArrayList<>();
        users = new ArrayList<>();
        engines = new ArrayList<>();
        initiateDummyData();
    }

    private void initiateDummyData() {
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
    }

    public static Database getInstance(){
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }

    @Override
    public ArrayList<User> getUsers() {
        return users;
    }

    @Override
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
    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void addCar(Car car) {
        cars.add(car);
    }
}
