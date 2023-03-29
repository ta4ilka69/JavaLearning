package Commands.Interactive;

import Collection.MyCollection;
import Commands.AbstractCommand;

/**
 * Command for printing soundtracks of elements in collection in sorted way.
 * @see MyCollection
 * @see AbstractCommand
 */
public class PrintSoundtrackUpCommand extends AbstractCommand {
    /**
     * Initialize command.
     * @param collection sets collection.
     */
    public PrintSoundtrackUpCommand(MyCollection collection) {
        super(collection, null);
    }
    /**
     * @return name of command.
     */
    public String toString() {
        return "print_field_ascending_soundtrack_name";
    }
    /**
     * @return information for "help" command.
     */
    public static String info() {
        return "print_field_ascending_soundtrack_name : вывести значения поля soundtrackName всех элементов в порядке возрастания";
    }

    /**
     * prints tracks in sorted way.
     */
    @Override
    public void execute() {
        getCollection().soundUp();
    }
}
