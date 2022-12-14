package database;

import model.User;
import model.car.Car;

import java.util.ArrayList;

public class DatabaseProxy implements IDatabase {
    private Database database;
    private Boolean isAuthenticated;

    public DatabaseProxy(User user) {
        if(user.getAdmin()) {
            isAuthenticated = true;
        } else {
            isAuthenticated = false;
        }
    }

    @Override
    public ArrayList<User> getUsers() {
        return null;
    }

    @Override
    public ArrayList<Car> getCars() {
        return null;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void addCar(Car car) {

    }
}
