package Commands.Interactive;

import Collection.MyCollection;
import Commands.AbstractCommand;

/**
 * Command for clearing collection.
 * @see MyCollection
 * @see AbstractCommand
 */
public class ClearCommand extends AbstractCommand {
    /**
     * Initialize command with collection, set HumanBeing element to null as it is not used.
     * @param collection sets collection.
     */
    public ClearCommand(MyCollection collection) {
        super(collection, null);
    }

    /**
     * Clears collection.
     */
    @Override
    public void execute() {
        getCollection().clear();
    }
    /**
     * @return name of command.
     */
    @Override
    public String toString() {
        return "clear";
    }
    /**
     * @return information for "help" command.
     */
    public static String info() {
        return "clear : очистить коллекцию";
    }
}
