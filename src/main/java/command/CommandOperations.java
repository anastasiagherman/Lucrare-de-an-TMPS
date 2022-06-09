package command;

import DatabaseOperation.DeleteApp;
import DatabaseOperation.InsertApp;
import DatabaseOperation.UpdateApp;
import entity.GuestInfo;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.UUID;

public class CommandOperations {
    Scanner input = new Scanner(System.in);
    public void addCostumer(){
        GuestInfo guest = new GuestInfo();
        guest.setGuestId(UUID.randomUUID().toString());
        System.out.print("Name: ");
        guest.setName(input.nextLine());
        System.out.print("Phone: ");
        guest.setPhone_nr(input.nextLine());
        System.out.print("Checkin date: ");
        guest.setCheckinDate(input.nextLine());
        System.out.print("Number of days: ");
        guest.setNrDays(Integer.parseInt(input.nextLine()));
        System.out.print("Checkout date: ");
        guest.setCheckoutDate(input.nextLine());
        System.out.print("Room Number: ");
        guest.setRoomNr(Integer.parseInt(input.nextLine()));
        InsertApp insertGuest = new InsertApp();
        insertGuest.insert(guest);
        UpdateApp update = new UpdateApp();
        update.updateRoomStatusOccupied(guest.getRoomNr());
        System.out.println("Mr./Mm " + guest.getName() + " is staying in room nr " + guest.getRoomNr() + " for " + guest.getNrDays() + " days");
    }

    public void deleteCostumer(){
        String guestName = input.nextLine();
        int roomNr = input.nextInt();
        DeleteApp delete = new DeleteApp();
        delete.delete(guestName, roomNr);
        UpdateApp update = new UpdateApp();
        update.updateRoomStatusEmpty(roomNr);
        System.out.println("Mr./Mm " + guestName + " has leaved the room nr. ");
    }

}
