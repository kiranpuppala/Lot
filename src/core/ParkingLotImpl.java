package core;

import models.Slot;
import utils.LinkedList;
import utils.OutOfParkingSlotsException;

import java.util.*;

public class ParkingLotImpl implements ParkingLot{

    private static final String LOG_TAG = ParkingLotImpl.class.getSimpleName();
    private LinkedList freeSlots = new LinkedList();
    private Map<Integer, Slot> slotsInfo = new HashMap<>();
    private Map<String, List<Integer>> colourMaping = new HashMap<String, List<Integer>>();
    private LinkedList.Node newNode;
    List<Integer> slots = new ArrayList<Integer>();

    public LinkedList getFreeSlots() {
        return freeSlots;
    }

    @Override
    public void createParkingSlot(int numberOfSlots) {
        for(int i=1; i <= numberOfSlots; i++) {
            newNode = freeSlots.newNode(i);
            freeSlots.insertInOrder(newNode);
        }
    }

    @Override
    public void park(String regNo, String colour) throws OutOfParkingSlotsException {
        int newSlotNumber = freeSlots.getFromList();
        if(newSlotNumber == -1) {
            throw new OutOfParkingSlotsException("Parking Full");
        } else {
            System.out.println("Allocated slot number:" + newSlotNumber);
            slotsInfo.put(newSlotNumber, new Slot(colour, regNo));

            if(colourMaping.containsKey(colour.toLowerCase())){
                slots = colourMaping.get(colour.toLowerCase());
            }
            slots.add(newSlotNumber);
            colourMaping.put(colour.toLowerCase(), slots);

        }
    }

    @Override
    public void leaveSlot(int slotNo) {
        if(slotsInfo.containsKey(slotNo)) {
            String colour = slotsInfo.get(slotNo).getColor();
            slots = colourMaping.get(colour.toLowerCase());
            slots.remove(new Integer(slotNo));
            if(slots.size() == 0)
                colourMaping.remove(colour.toLowerCase());
            else
                colourMaping.put(colour.toLowerCase(), slots);
            slotsInfo.remove(slotNo);
            System.out.println("Slot number " + slotNo + " is free");
            newNode = freeSlots.newNode(slotNo);
            freeSlots.insertInOrder(newNode);

        } else {
            System.out.println("Slot number " + slotNo + " is already empty" );
        }
    }

    @Override
    public void status() {
        Iterator<Integer> iterator = slotsInfo.keySet().iterator();
        System.out.println("Slot No  Registration No   Colour");
        while(iterator.hasNext()){
            int key = iterator.next();
            System.out.println(String.format("%-9d", key) + String.format("%-18s", slotsInfo.get(key).getRegNo())+ String.format("%s", slotsInfo.get(key).getColor()));
        }
    }

    @Override
    public void getSlotNumbersByColour(String colour) {
        if(colourMaping.containsKey(colour.toLowerCase())) {
            System.out.println(colourMaping.get(colour.toLowerCase()));
        } else {
            System.out.println("No Slots are allocated to given number");
        }
    }

    @Override
    public void getVehicleNumberByColour(String colour) {
        slots = colourMaping.get(colour.toLowerCase());
        List<String> vehicleNumbers = new ArrayList<>(Collections.emptyList());
        for (Integer slot : slots) {
            vehicleNumbers.add(slotsInfo.get(slot).getRegNo());
        }
        System.out.println(vehicleNumbers);
    }


    @Override
    public void showSlots(){
        freeSlots.printList();
    }

}
