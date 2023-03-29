package Commands.Interactive;

import Commands.AbstractCommand;

/**
 * Class for handling unknown commands.
 * @see AbstractCommand
 */
public class UnknownCommand extends AbstractCommand {
    /**
     * Name of command (is unknown).
     */
    private String command;

    /**
     * Initialize command.
     * @param command sets command name given.
     */

    public UnknownCommand(String command) {
        super(null, null);
        this.command = command;
    }

    /**
     * Telling user that command is unknown.
     */
    @Override
    public void execute() {
        System.out.println("Unknown command");
    }
    /**
     * @return information for "help" command.
     */
    public static String info() {
        return "No info about unknown command";
    }
}
