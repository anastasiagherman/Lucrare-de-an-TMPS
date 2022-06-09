package entity;
import DatabaseOperation.SelectInfo;
import composite.Accommodation;
import composite.Apartment;

public class Room implements Accommodation {
    private int roomId;
    private String roomType;
    private double roomPrice;
    private String roomGuest;
    private String roomStatus;
    private String roomService;
    private String miniBar;
    private boolean empty;
    private int sqm;
    private String details;

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
    public void setSqm(int sqm){
     this.sqm = sqm;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomType='" + roomType + '\'' +
                ", roomPrice=" + roomPrice +
                ", roomGuest='" + roomGuest + '\'' +
                ", roomStatus='" + roomStatus + '\'' +
                ", roomService='" + roomService + '\'' +
                ", miniBar='" + miniBar + '\'' +
                ", sqm=" + sqm +
                ", details='" + details + '\'' +
                '}' + '\n';
    }


    @Override
    public int getSqm() {
        return this.sqm;
    }

    @Override
    public String getDetails() {
        return null;
    }
}
