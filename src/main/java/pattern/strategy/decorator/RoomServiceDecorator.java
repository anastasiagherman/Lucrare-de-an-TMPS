package pattern.strategy.decorator;

import DatabaseOperation.UpdateApp;

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
