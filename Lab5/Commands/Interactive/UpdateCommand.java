package Commands.Interactive;

import Collection.MyCollection;
import Commands.AbstractCommand;
import ElementClasses.HumanBeing;

/**
 * Update command rewrite the element with given id.
 * @see AbstractCommand
 * @see MyCollection
 * @see HumanBeing
 */
public class UpdateCommand extends AbstractCommand {
    /**
     * id of the element.
     */
    private int id;

    /**
     * Initialize command.
     * @param collection sets collection.
     * @param h sets element (this element will be written).
     * @param id sets id of element.
     */

    public UpdateCommand(MyCollection collection, HumanBeing h, int id) {
        super(collection, h);
        this.id = id;
    }
    /**
     * @return name of command.
     */
    public String toString() {
        return "update";
    }
    /**
     * @return information for "help" command.
     */
    public static String info() {
        return "update id {element} : обновить значение элемента коллекции, id которого равен заданному";
    }

    /**
     * Update element with new fields by given id.
     */
    @Override
    public void execute() {
        getCollection().update(getElement(), id);
    }
}
