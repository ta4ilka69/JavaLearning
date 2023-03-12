package Collection.Commands.Interactive;

import Collection.Commands.AbstractCommand;

public class ErrorCommand extends AbstractCommand {
    private String problem;
    private String command;
    public ErrorCommand(String problem,String command){
        super(null,null);
        this.command = command;
        this.problem = problem;
    }

    @Override
    public void execute() {
        System.out.println(this.problem);
    }

    public static String info(){
        return "Command with error";
    }
}
