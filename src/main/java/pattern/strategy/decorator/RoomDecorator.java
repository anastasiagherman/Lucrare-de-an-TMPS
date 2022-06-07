package pattern.strategy.decorator;

public abstract class RoomDecorator implements IRoom {
    private IRoom room;

    public RoomDecorator(IRoom room){
        this.room = room;
    }

    public void getRoom(int roomNr){
        this.room.getRoom(roomNr);
    }
}
