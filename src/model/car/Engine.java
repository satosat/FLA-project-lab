package model.car;

import prototype.Clone;

public class Engine implements Clone {
    private int horsepower;
    private double capacity;
    private int cyclinderCount;
    private String configuration;

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
