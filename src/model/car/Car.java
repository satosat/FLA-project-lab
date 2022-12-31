package model.car;

import model.car.seat.Seat;

public class Car {
    private String name;
    private String Color;
    private int DoorCount;
    private Engine engine;
    private Wheel wheel;
    private Seat seat;
    private int price;

    public Car(){}

    public Car(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public int getDoorCount() {
        return DoorCount;
    }

    public void setDoorCount(int doorCount) {
        DoorCount = doorCount;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Wheel getWheel() {
        return wheel;
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
