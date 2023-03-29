package Commands.Interactive;

import Collection.MyCollection;
import Commands.AbstractCommand;

/**
 * Command for showing all elements of collection.
 * @see AbstractCommand
 * @see MyCollection
 * @see ElementClasses.HumanBeing
 */
public class ShowCommand extends AbstractCommand {
    /**
     * Initialize command.
     * @param collection sets collection.
     */
    public ShowCommand(MyCollection collection) {
        super(collection, null);
    }
    /**
     * @return name of command.
     */
    @Override
    public String toString() {
        return "show";
    }

    /**
     * Prints into console all elements with all fields.
     */
    @Override
    public void execute() {
        getCollection().show();
    }
    /**
     * @return information for "help" command.
     */
    public static String info() {
        return "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
