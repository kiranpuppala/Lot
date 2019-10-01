package core;

import utils.OutOfParkingSlotsException;

public interface ParkingLot {

    void createParkingSlot(int numberOfSlots);

    void park(String regNo, String colour) throws OutOfParkingSlotsException;;

    void leaveSlot(int slotNo);

    void status();

    void getSlotNumbersByColour(String colour);

    void getVehicleNumberByColour(String colour);

    void showSlots();
}
