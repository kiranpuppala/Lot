package models;

public class Slot {
    private String color;
    private String regNo;
    public Slot(String color, String regNo) {
        this.color = color;
        this.regNo = regNo;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setSlotNo(int slotNo) {
        this.regNo = regNo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
