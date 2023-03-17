package Commands.Interactive;

import Commands.AbstractCommand;

public class HelpCommand extends AbstractCommand {
    public HelpCommand(){
        super(null,null);
    }

    @Override
    public void execute() {
        System.out.println(AddElementCommand.info());
        System.out.println(HelpCommand.info());
        System.out.println(InfoCommand.info());
        System.out.println(ShowCommand.info());
        System.out.println(UpdateCommand.info());
        System.out.println(RemoveByIdCommand.info());
        System.out.println(ClearCommand.info());
        System.out.println(SaveCommand.info());
        System.out.println(ExecuteScript.info());
        System.out.println(ExitCommand.info());
        System.out.println(RemoveHeadCommand.info());
        System.out.println(RemoveGreaterCommand.info());
        System.out.println(HistoryCommand.info());
        System.out.println(CountGreaterThanCarCommand.info());
        System.out.println(PrintDescendingCommand.info());
        System.out.println(PrintSoundtrackUpCommand.info());
    }

    public static String info() {
        return "help : вывести справку по доступным командам";
    }

    public String toString(){
        return "help";
    }
}
