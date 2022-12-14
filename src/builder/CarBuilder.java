package builder;

import model.car.Car;

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
}
