package Commands.Interactive;

import Commands.AbstractCommand;

/**
 * Command to manage all errors when trying to execute another commands.
 * @see AbstractCommand
 */
public class ErrorCommand extends AbstractCommand {
    /**
     * Error occurred, will be print in console.
     */
    private String problem;
    /**
     * Name of command that ended up with error.
     */
    private String command;

    /**
     * Initizlize command
     * @param problem sets error message.
     * @param command sets name of command.
     */
    public ErrorCommand(String problem, String command) {
        super(null, null);
        this.command = command;
        this.problem = problem;
    }

    /**
     * Print error message.
     */
    @Override
    public void execute() {
        System.out.println(this.problem);
    }
    /**
     * @return information for "help" command.
     */
    public static String info() {
        return "Command with error";
    }
    /**
     * @return name of command.
     */
    @Override
    public String toString() {
        return "error";
    }
}
