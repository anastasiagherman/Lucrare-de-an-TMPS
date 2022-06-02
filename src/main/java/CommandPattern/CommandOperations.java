package CommandPattern;

import DatabaseOperation.DeleteApp;
import DatabaseOperation.InsertApp;
import Entity.GuestInfo;

import java.util.Scanner;

public class CommandOperations {
    public void addCostumer(){
        Scanner input = new Scanner(System.in);
        GuestInfo guest = new GuestInfo();
        guest.setGuest_id(input.nextInt());
        guest.setName(input.nextLine());
        guest.setPhone_nr(input.nextLine());
        guest.setCheckinDate(input.nextLine());
        guest.setNrDays(input.nextInt());
        guest.setCheckoutDate(input.nextLine());
        guest.setRoomNr(input.nextInt());
        InsertApp insertGuest = new InsertApp();
        insertGuest.insert(guest.getGuest_id(),guest.getName(), guest.getPhone_nr(), guest.getCheckinDate(), guest.getNrDays(), guest.getCheckoutDate(), guest.getRoomNr());
        System.out.println("Mr./Mm " + guest.getName() + "is staying in room " + guest.getRoomNr() + "for" + guest.getNrDays());
    }

    public void deleteCostumer(String guestName, int roomNr){
        DeleteApp delete = new DeleteApp();
        delete.delete(guestName);
        System.out.println("Mr./Mm" + guestName + "has leaved the room nr." + roomNr );
    }

}
