package Commands.Interactive;

import Collection.MyCollection;
import Commands.AbstractCommand;
import ElementClasses.HumanBeing;

/**
 * Remove all elements greater than given command.
 * @see MyCollection
 * @see HumanBeing
 * @see AbstractCommand
 */
public class RemoveGreaterCommand extends AbstractCommand {
    /**
     * Initialize command.
     * @param collection sets collection.
     * @param h sets element.
     */
    public RemoveGreaterCommand(MyCollection collection, HumanBeing h) {
        super(collection, h);
    }

    /**
     * Removes elements greater than given.
     */
    @Override
    public void execute() {
        getCollection().removeGreater(getElement());
    }
    /**
     * @return name of command.
     */
    @Override
    public String toString() {
        return "remove_greater";
    }
    /**
     * @return information for "help" command.
     */
    public static String info() {
        return "remove_greater {element} : удалить из коллекции все элементы, превышающие заданный";
    }
}
