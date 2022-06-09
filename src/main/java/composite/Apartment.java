package composite;

import DatabaseOperation.SelectInfo;
import entity.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Apartment implements Accommodation {
    private int apartmentId;
    private double apartmentPrice;
    private String apartmentGuest;
    private String roomService;
    private String miniBar;
    private boolean empty;
    private String roomIdList;
    private List<Room> roomList = null;

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int getSqm() {
        int sqm = 0;
        for (Room room:getRooms()) {
            sqm = sqm + room.getSqm();
        }
        return sqm;
    }

    @Override
    public String getDetails() {
        return "This apartment has " +  getRooms().size()+ " rooms" ;
    }

    public List<Room> getRooms(){
        if (roomList == null || roomList.isEmpty()){
            roomList = new ArrayList<>();
            SelectInfo rooms = new SelectInfo();
            List<Integer> roomIds = Arrays.stream(roomIdList.split(",")).map(Integer::parseInt).toList();
            for (Room room : rooms.selectRooms("SELECT * FROM rooms where room_type = 'APT'")) {
                if(roomIds.contains(room.getRoomId())) {
                    roomList.add(room);
                }
            }
        }
        return roomList;
    }

    public int getApartmentId() {
        return apartmentId;
    }

    public double getApartmentPrice() {
        return apartmentPrice;
    }

    public String getApartmentGuest() {
        return apartmentGuest;
    }

    public String getRoomService() {
        return roomService;
    }

    public String getMiniBar() {
        return miniBar;
    }

    public String getRoomIdList() {
        return roomIdList;
    }

    public void setApartmentId(int apartmentId) {
        this.apartmentId = apartmentId;
    }

    public void setApartmentPrice(double apartmentPrice) {
        this.apartmentPrice = apartmentPrice;
    }

    public void setApartmentGuest(String apartmentGuest) {
        this.apartmentGuest = apartmentGuest;
    }

    public void setRoomService(String roomService) {
        this.roomService = roomService;
    }

    public void setMiniBar(String miniBar) {
        this.miniBar = miniBar;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public void setRoomIdList(String roomIdList) {
        this.roomIdList = roomIdList;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "apartmentId=" + apartmentId +
                ", apartmentPrice=" + apartmentPrice +
                ", apartmentGuest='" + apartmentGuest + '\'' +
                ", roomService='" + roomService + '\'' +
                ", miniBar='" + miniBar + '\'' +
                ", empty=" + empty +
                ", roomList=" + getRooms() +
                '}';
    }
}
