package design.Parking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SlotFactory {



    Map<Integer,List<ParkingSlot>> floorWiseMap = new HashMap<>();

    public SlotFactory(){
        postConstuct();
    }
    public void postConstuct(){
        //Create map of slots.
    }

    //return slots on the basis of Vechile diamensions.
    public static List<ParkingSlot> getSlotsForParking(Vechile vechile){
        //Need to handle floor wise synchronization.
        return null;
    }
}
