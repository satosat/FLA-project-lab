package prototype;

import model.car.Engine;

import java.util.ArrayList;

public class EngineRegistry {
    private ArrayList<Engine> engines = new ArrayList<>();

    public void initiate(){
        // get engines from database
    }
    public ArrayList<Engine> getEngines() {
        return this.engines;
    }
}
