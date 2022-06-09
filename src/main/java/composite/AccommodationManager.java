package composite;

import DatabaseOperation.SelectApartmentInfo;
import DatabaseOperation.SelectInfo;
import entity.Room;

import java.util.ArrayList;
import java.util.List;

public class AccommodationManager {
    private final SelectInfo roomsInfo;
    private final SelectApartmentInfo aptInfo;

    public AccommodationManager(){
        roomsInfo = new SelectInfo();
        aptInfo = new SelectApartmentInfo();
    }

    public List<Apartment> getApartments() {

        return aptInfo.selectApartments();
    }

    public List<Room> getRooms() {
        return roomsInfo.selectRooms( "SELECT * FROM rooms where room_type IN ('SINGLE', 'DOUBLE')");
    }

    public List<Accommodation> getAccommodation() {
        List<Accommodation> acList = new ArrayList<>();
        acList.addAll(aptInfo.selectApartments());
        acList.addAll(roomsInfo.selectRooms("SELECT * FROM rooms where room_type IN ('SINGLE', 'DOUBLE')"));
        return acList;
    }
}
