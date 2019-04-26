package design.Parking;

import java.util.ArrayList;
import java.util.List;

public class FreeSlotNotifier {
    List<ParkingSlotObserver> parkingSlotObservers = new ArrayList<>();
    public void collectParkingSlotObserver(ParkingSlotObserver parkingSlotObserver){
        this.parkingSlotObservers.add(parkingSlotObserver);
    }

}
