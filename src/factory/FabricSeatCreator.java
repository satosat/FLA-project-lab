package factory;

import model.car.seat.FabricSeat;
import model.car.seat.Seat;

public class FabricSeatCreator extends SeatCreator{
    @Override
    public Seat createSeat() {
        return new FabricSeat();
    }
}
