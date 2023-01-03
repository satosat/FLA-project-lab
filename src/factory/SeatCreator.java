package factory;

import model.car.seat.Seat;

public abstract class SeatCreator {

    public abstract Seat createSeat();

    public Seat useSeat(){
        Seat seat = createSeat();
        System.out.println("Applied " + seat.material() + " seat into your car!");
        return seat;
    }
}
