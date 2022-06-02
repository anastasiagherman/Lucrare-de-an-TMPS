package CommandPattern;

import CommandPattern.CommandManager;

public class InformationModifier {
    private CommandManager command;

    public InformationModifier(CommandManager command){
        super();
        this.command = command;
    }

    public CommandManager getCommand(){
        return command;
    }

    public void setCommand(CommandManager command){
        this.command = command;

    }

    public void execute(){
        this.command.execute();
    }

}
