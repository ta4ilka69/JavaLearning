package Commands;

import Collection.MyCollection;
import Commands.Interactive.SaveCommand;

/**
 * Command for saving collection into temporary file.
 * @see MyCollection
 * @see SaveCommand
 */
public class SaveTemp extends SaveCommand {
    /**
     * invoke super constructor to initialize class object.
     * @param collection sets collection.
     */
    public SaveTemp(MyCollection collection) {
        super(collection);
        this.setPath("tmp/temp.csv");
    }
}
