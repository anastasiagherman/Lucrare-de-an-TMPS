package pattern.strategy.decorator;

public class PersonalisedRoomFactory {
    private IRoom room;

    public IRoom createRoom(String roomFeatures, int roomNr){
        if (roomFeatures == null){
            return null;
        }
        if (roomFeatures.equalsIgnoreCase("Room Service")){
            return new RoomServiceDecorator(room);
        }
        else if (roomFeatures.equalsIgnoreCase("MiniBar")){
            return new MiniBarDecorator(room);
        }
        else if (roomFeatures.equalsIgnoreCase("MiniBar and Room Service")){
            return new RoomServiceDecorator(new MiniBarDecorator(room));
        }
        return null;

    }
}
