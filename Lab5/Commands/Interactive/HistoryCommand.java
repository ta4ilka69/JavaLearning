package Commands.Interactive;

import Collection.HistoryManager;
import Collection.MyCollection;
import Commands.AbstractCommand;

/**
 * Command for getting history of commands.
 * @see AbstractCommand
 */
public class HistoryCommand extends AbstractCommand {
    /**
     * Manager for history.
     * @see HistoryManager
     */
    private HistoryManager manager;

    /**
     * Initialize command.
     * @param manager sets manager.
     * @param collection sets collection.
     * @see MyCollection
     */

    public HistoryCommand(HistoryManager manager, MyCollection collection) {
        super(collection, null);
        this.manager = manager;
    }

    /**
     *Print history of commands.
     */
    @Override
    public void execute() {
        this.manager.printLast();
    }
    /**
     * @return information for "help" command.
     */
    public static String info() {
        return "history : вывести последние 6 команд (без их аргументов)";
    }
    /**
     * @return name of command.
     */
    @Override

    public String toString() {
        return "history";
    }
}
