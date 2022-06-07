package pattern.strategy.decorator;

import DatabaseOperation.UpdateApp;

public class MiniBarDecorator extends RoomDecorator{

    public MiniBarDecorator(IRoom room) {
        super(room);
    }

    @Override
    public void getRoom(int roomNr) {
        System.out.println("Minibar was added to the room");
        UpdateApp roomService = new UpdateApp();
        roomService.addMiniBar(roomNr);
        super.getRoom(roomNr);
    }
}
