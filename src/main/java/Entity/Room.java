package Entity;

import java.util.List;

public class Room {
    private int roomId;
    private String roomType;
    private double roomPrice;
    private String roomGuest;
    private String roomStatus;
    private String roomService;
    private String miniBar;
    private Apartment apartment;

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(){
        this.apartment = new Apartment();
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public void setRoomGuest(String roomGuest) {
        this.roomGuest = roomGuest;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public void setRoomService(String roomService) {
        this.roomService = roomService;
    }

    public void setMiniBar(String miniBar) {
        this.miniBar = miniBar;
    }

    public int getRoomId() {
        return roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public String getRoomGuest() {
        return roomGuest;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public String getRoomService() {
        return roomService;
    }

    public String getMiniBar() {
        return miniBar;
    }
}
