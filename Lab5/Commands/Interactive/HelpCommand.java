package Commands.Interactive;

import Commands.AbstractCommand;

/**
 * Command for getting all commands and their functions.
 * @see AbstractCommand
 */
public class HelpCommand extends AbstractCommand {
    /**
     * Initialize with null arguments. We don't need collection or element.
     */
    public HelpCommand() {
        super(null, null);
    }

    /**
     * Prints all commands and their descriptions.
     */
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
    /**
     * @return information for "help" command.
     */
    public static String info() {
        return "help : вывести справку по доступным командам";
    }
    /**
     * @return name of command.
     */
    public String toString() {
        return "help";
    }
}
