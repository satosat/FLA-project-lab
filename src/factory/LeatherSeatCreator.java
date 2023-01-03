package factory;


import model.car.seat.LeatherSeat;
import model.car.seat.Seat;

public class LeatherSeatCreator extends SeatCreator {
    @Override
    public Seat createSeat() {
        return new LeatherSeat();
    }
}
