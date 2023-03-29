package Commands.Interactive;

import Collection.MyCollection;
import Commands.AbstractCommand;

/**
 * Command for removing element by id.
 * @see MyCollection
 * @see AbstractCommand
 * @see ElementClasses.HumanBeing
 */
public class RemoveByIdCommand extends AbstractCommand {
    /**
     * id of element.
     */
    private int id;

    /**
     * Initialize command.
     * @param collection sets collection.
     * @param id sets id of item to remove.
     */
    public RemoveByIdCommand(MyCollection collection, int id) {
        super(collection, null);
        this.id = id;
    }

    /**
     * Removes element where id is as given.
     */
    @Override
    public void execute() {
        getCollection().removeById(id);
    }
    /**
     * @return name of command.
     */
    @Override
    public String toString() {
        return "remove_by_id";
    }
    /**
     * @return information for "help" command.
     */
    public static String info() {
        return "remove_by_id id : удалить элемент из коллекции по его id";
    }
}
