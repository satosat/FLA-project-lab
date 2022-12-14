package database;

import model.User;
import model.car.Car;

import java.util.ArrayList;

public interface IDatabase {
    public ArrayList<User> getUsers();
    public ArrayList<Car> getCars();
    public void addUser(User user);
    public void addCar(Car car);
}
