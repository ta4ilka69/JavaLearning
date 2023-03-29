package Commands.Interactive;

import Collection.MyCollection;
import Commands.AbstractCommand;

/**
 * Command for printing reversed sorted list of collection.
 * @see MyCollection
 * @see AbstractCommand
 */
public class PrintDescendingCommand extends AbstractCommand {
    /**
     * Initialize command
     * @param collection sets collection.
     */
    public PrintDescendingCommand(MyCollection collection) {
        super(collection, null);
    }

    /**
     * Prints collection in reversed sorted order.
     */
    @Override
    public void execute() {
        getCollection().printDescending();
    }
    /**
     * @return name of command.
     */
    public String toString() {
        return "print_descending";
    }
    /**
     * @return information for "help" command.
     */
    public static String info() {
        return "print_descending : вывести элементы коллекции в порядке убывания";
    }
}
