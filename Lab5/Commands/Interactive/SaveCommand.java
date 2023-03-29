package Commands.Interactive;

import Collection.MyCollection;
import Commands.AbstractCommand;
import FileManager.CollectionWriter;

/**
 * Command for saving collection.
 * @see MyCollection
 * @see AbstractCommand
 */
public class SaveCommand extends AbstractCommand {
    /**
     * Path to save.
     */
    private String path;

    /**
     * Initialize command. Path is taken from collection method.
     * @param collection sets collection
     */

    public SaveCommand(MyCollection collection) {
        super(collection, null);
        this.path = collection.getPathToSave();
    }

    /**
     * Writes collection into file.
     * @see CollectionWriter
     */
    @Override
    public void execute() {
        String oldPath = getCollection().getPathToSave();
        getCollection().setPathToSave(path);
        CollectionWriter writer = new CollectionWriter(this.getCollection());
        writer.execute();
        getCollection().setPathToSave(oldPath);
    }
    /**
     * @return information for "help" command.
     */
    public static String info() {
        return "save : сохранить коллекцию в файл";
    }
    /**
     * @return name of command.
     */
    @Override
    public String toString() {
        return "save";
    }

    /**
     * @param path sets path for saving.
     */
    public void setPath(String path) {
        this.path = path;
    }
}
