package model.car;

import prototype.Clone;

public class Engine implements Clone {
    private int horsepower;
    private double capacity;
    private int cyclinderCount;
    private String configuration;

    public Engine(int horsepower, double capacity, int cyclinderCount, String configuration) {
        this.horsepower = horsepower;
        this.capacity = capacity;
        this.cyclinderCount = cyclinderCount;
        this.configuration = configuration;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public double getCapacity() {
        return capacity;
    }

    public int getCyclinderCount() {
        return cyclinderCount;
    }

    public String getConfiguration() {
        return configuration;
    }

    public String getSpecification(){
        return this.getHorsepower() + " HP " + this.getCapacity() + "L " + this.getConfiguration() + this.getCyclinderCount() + " Engine";
    }
    @Override
    public Clone createClone() {
        Engine clone = null;
        try {
            clone = (Engine) this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
