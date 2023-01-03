package model;

import model.car.Car;

import java.util.ArrayList;

public class User {
    private String name;
    private String email;
    private String phoneNumber;
    private Boolean isAdmin;

    private ArrayList<Car> boughtCars;

    public User(String name, String email, String phoneNumber, Boolean isAdmin) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.isAdmin = isAdmin;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public ArrayList<Car> getBoughtCars() {
        return boughtCars;
    }

    public void addBoughtCars(Car newCar) {
        boughtCars.add(newCar);
    }
}
