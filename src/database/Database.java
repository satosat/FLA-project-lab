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

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void addCar(Car car) {
        cars.add(car);
    }
}
