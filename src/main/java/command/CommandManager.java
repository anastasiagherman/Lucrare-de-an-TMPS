package command;

public class CommandManager implements Command {
    private CommandOperations operation;
    private String operationType;
    private String guestName;
    private int roomNr;


    public CommandManager(CommandOperations operation, String operationType){
        this.operation = operation;
        this.operationType = operationType;
    }
    public CommandManager(CommandOperations operation, String operationType,String guestName, int roomNr){
        this.operation = operation;
        this.operationType = operationType;
        this.guestName = guestName;
        this.roomNr = roomNr;
    }
    @Override
    public void execute() {
        if(operationType.equalsIgnoreCase("checkin")) {
            this.operation.addCostumer();
        }
        else if(operationType.equalsIgnoreCase("checkout")) {
            this.operation.deleteCostumer();
        }

    }
}
