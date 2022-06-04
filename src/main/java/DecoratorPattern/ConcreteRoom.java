package DecoratorPattern;

import DatabaseOperation.SelectInfo;

import java.util.Scanner;

public class ConcreteRoom implements IRoom{


    @Override
    public void getRoom(int roomNr) {
        SelectInfo roomInfo = new SelectInfo();
        roomInfo.selectSpecificRoom(roomNr);
    }
}
