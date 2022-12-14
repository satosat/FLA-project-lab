package model.car.seat;

public class SeatLeather implements Seat{

    @Override
    public String material(){
        return "Leather";
    }

    @Override
    public String colour(){
        return "Fabric";
    }
}
