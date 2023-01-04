package model;

import database.Database;
import model.car.Car;
import observer.Observer;

import java.util.ArrayList;

public class User implements Observer {
    private String name;
    private String email;
    private String phoneNumber;
    private Boolean isAdmin;

    private ArrayList<String> promos;

    public User(String name, String email, String phoneNumber, Boolean isAdmin) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.isAdmin = isAdmin;
        promos = new ArrayList<String>();
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
        return Database.getInstance().getTransactions(this);
    }

    public void addBoughtCars(Car newCar) {
        Database database = Database.getInstance();
        database.addTransaction(this, newCar);
    }

    @Override
    public void update(String message)
    {
        promos.add(message);
    }

    public void showPromos()
    {
        if(promos.size() == 0) {
            System.out.println("You don't have any new promo.");
            return;
        }

        System.out.println("You've got new promo(s)!");

        int i = 1;
        for (String promo :
                promos) {
            System.out.println(i++ + ". " + promo);
        }

        System.out.println("============================================================");

        // clear promo after user has seen it.
        clearPromos();
    }

    public void clearPromos()
    {
        promos.removeAll(promos);
    }
    public boolean isAdmin(){
        return this.isAdmin;
    }
}
