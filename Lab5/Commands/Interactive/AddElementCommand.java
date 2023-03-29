package Commands.Interactive;

import Collection.MyCollection;
import Commands.AbstractCommand;
import ElementClasses.HumanBeing;

/**
 *Command for adding an element.
 * @see AbstractCommand
 */
public class AddElementCommand extends AbstractCommand {
    /**
     * Initialize command.
     * @param collection sets collection into super constructor.
     * @param h sets element to add.
     * @see HumanBeing
     * @see MyCollection
     */
    public AddElementCommand(MyCollection collection, HumanBeing h) {
        super(collection, h);
    }

    /**
     * Add new element into collection.
     */
    public void execute() {
        super.getCollection().add(super.getElement());
    }

    /**
     * @return information for "help" command.
     */
    public static String info() {
        return "add {element} : добавить новый элемент в коллекцию";
    }

    /**
     * @return name of command.
     */
    public String toString() {
        return "add";
    }
}
