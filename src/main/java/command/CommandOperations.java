package command;

import DatabaseOperation.DeleteApp;
import DatabaseOperation.InsertApp;
import Entity.GuestInfo;

import java.util.Scanner;
import java.util.UUID;

public class CommandOperations {
    Scanner input = new Scanner(System.in);
    public void addCostumer(){
        GuestInfo guest = new GuestInfo();
        guest.setGuestId(UUID.randomUUID().toString());
        guest.setName(input.nextLine());
        guest.setPhone_nr(input.nextLine());
        guest.setCheckinDate(input.nextLine());
        guest.setNrDays(Integer.parseInt(input.nextLine()));
        guest.setCheckoutDate(input.nextLine());
        guest.setRoomNr(Integer.parseInt(input.nextLine()));
        InsertApp insertGuest = new InsertApp();
        insertGuest.insert(guest);
        System.out.println("Mr./Mm " + guest.getName() + " is staying in room " + guest.getRoomNr() + "for" + guest.getNrDays() + "days");
    }

    public void deleteCostumer(){
        String guestName = input.nextLine();
        DeleteApp delete = new DeleteApp();
        delete.delete(guestName);
        System.out.println("Mr./Mm " + guestName + " has leaved the room nr. ");
    }

}
