package Commands.Interactive;

import Collection.MyCollection;
import Commands.AbstractCommand;

/**
 * Command for printing info about collection.
 * @see AbstractCommand
 * @see MyCollection
 */
public class InfoCommand extends AbstractCommand {
    /**
     * Initialize command.
     * @param collection sets collection
     */
    public InfoCommand(MyCollection collection) {
        super(collection, null);
    }

    /**
     * Prints info about collection.
     */
    @Override
    public void execute() {
        getCollection().printInfo();
    }
    /**
     * @return name of command.
     */
    @Override
    public String toString() {
        return "info";
    }
    /**
     * @return information for "help" command.
     */
    public static String info() {
        return "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }
}
