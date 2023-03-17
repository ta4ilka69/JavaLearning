package Commands.Interactive;

import Commands.AbstractCommand;

public class ErrorCommand extends AbstractCommand{
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

    @Override
    public String toString() {
        return "error";
    }
}
