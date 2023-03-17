package Commands.Interactive;

import Commands.AbstractCommand;
import Commands.Executable;

public class UnknownCommand extends AbstractCommand {
    private String command;
    public UnknownCommand(String command){
        super(null,null);
        this.command = command;
    }

    @Override
    public void execute() {
        System.out.println("Unknown command");
    }

    public static String info(){
        return "No info about unknown command";
    }
}
