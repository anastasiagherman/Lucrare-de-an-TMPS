package DecoratorPattern;

import DatabaseOperation.UpdateApp;

import java.util.Scanner;

public class RoomServiceDecorator extends RoomDecorator{
    public RoomServiceDecorator(IRoom room) {
        super(room);
    }
    public void getRoom(int roomNr){
        System.out.println("Room Service was added to your room");
        UpdateApp roomService = new UpdateApp();
        roomService.addRoomService(roomNr);
        super.getRoom(roomNr);
    }
}
