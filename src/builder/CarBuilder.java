package builder;

import model.car.Car;
import model.car.Engine;
import model.car.Wheel;
import model.car.seat.Seat;

public class CarBuilder {
    private Car car;
    public CarBuilder(){
        car = new Car();
    }


    public Car build(){
        return this.car;
    }
    public void reset(){
        car = new Car();
    }

    public void setName(String name) {
        car.setName(name);
    }

    public void setColor(String color) {
        car.setColor(color);
    }

    public void setDoorCount(int doorCount) {
        car.setDoorCount(doorCount);
    }

    public void setEngine(Engine engine) {
        car.setEngine(engine);
    }

    public void setWheel(Wheel wheel) {
        car.setWheel(wheel);
    }

    public void setSeat(Seat seat) {
        car.setSeat(seat);
    }

    public void setPrice(int price) {
        car.setPrice(price);
    }
}
