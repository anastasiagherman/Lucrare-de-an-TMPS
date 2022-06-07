package pattern.strategy.decorator;

import DatabaseOperation.SelectInfo;

public class ConcreteRoom implements IRoom{


    @Override
    public void getRoom(int roomNr) {
        SelectInfo roomInfo = new SelectInfo();
        roomInfo.selectSpecificRoom(roomNr);
    }
}
