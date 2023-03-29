package Commands.Interactive;

import Collection.MyCollection;
import Commands.AbstractCommand;

/**
 * Command for printing and removing the first element of collection.
 * @see MyCollection
 * @see AbstractCommand
 */
public class RemoveHeadCommand extends AbstractCommand {
    /**
     * Initialize command.
     * @param collection sets collection.
     */
    public RemoveHeadCommand(MyCollection collection) {
        super(collection, null);
    }

    /**
     * Prints and removes first element.
     */
    @Override
    public void execute() {
        getCollection().removeHead();
    }
    /**
     * @return name of command.
     */
    public String toString() {
        return "remove_head";
    }
    /**
     * @return information for "help" command.
     */
    public static String info() {
        return "remove_head : вывести первый элемент коллекции и удалить его";
    }
}
