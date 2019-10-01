import core.ParkingLot;
import core.ParkingLotImpl;
import utils.OutOfParkingSlotsException;

import constants.Constants.*;

public class Tester {

    private static final String LOG_TAG = Tester.class.getSimpleName();

    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLotImpl();
        parkingLot.createParkingSlot(10);
//        parkingLot.showSlots();
        try {
            parkingLot.park("KA-05-KE1840", VehicleColor.WHITE);
        } catch (OutOfParkingSlotsException e) {
            System.out.println(String.format("%s : %s",LOG_TAG,e.getMessage()));
        }
        try {
            parkingLot.park("KA-05-KE1240", VehicleColor.BLACK);
        } catch (OutOfParkingSlotsException e) {
            System.out.println(String.format("%s : %s",LOG_TAG,e.getMessage()));
        }
//        parkingLot.leaveSlot(2);
//        parkingLot.showSlots();
        parkingLot.status();
        parkingLot.getSlotNumbersByColour(VehicleColor.WHITE);
        parkingLot.getVehicleNumberByColour(VehicleColor.WHITE);
    }
}
