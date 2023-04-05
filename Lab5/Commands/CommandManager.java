package Commands;

import Collection.CollectionManager;
import Collection.MyCollection;
import FileManager.ReaderMode;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class that gets lines from source and try to execute them.
 */
public class CommandManager {
    /**
     * Source of input.
     */
    private InputStream input;
    /**
     * Scanner for reading commands.
     */
    private Scanner scanner;
    /**
     * CollectionManager for interpreting commands from string.
     * @see CollectionManager
     */
    private CollectionManager collectionManager;
    /**
     * Mode of working with collection
     * @see ReaderMode
     */
    private ReaderMode mode;

    /**
     * Constructor for class. Sets all fields. Also takes <i>deep</i> argument to prevent a recursive call.
     * @param in sets input source.
     * @param collection for setting CollectionManager.
     * @param mode sets mode.
     * @param loaded_scripts for setting CollectionManager.
     * @see MyCollection
     * @see CollectionManager
     */
    public CommandManager(InputStream in, MyCollection collection, ReaderMode mode, ArrayList<String> loaded_scripts) {
        this.input = in;
        this.scanner = new Scanner(in);
        collectionManager = new CollectionManager(collection, scanner, mode, loaded_scripts);
        this.mode = mode;
    }

    /**
     * Start reading from source. Execute interpreted commands.
     */
    public void start() {
        String nextline = scanner.hasNext() ? scanner.nextLine() : "";
        boolean endOfInput = false;
        while (!nextline.equals("exit") && (!endOfInput)) {
            String[] command = nextline.split(" ");
            collectionManager.getCommand(command).execute();
            if (scanner.hasNext()) {
                nextline = scanner.nextLine();
            } else {
                endOfInput = true;
            }
            new SaveTemp(collectionManager.getCollection()).execute();
        }
        if (!endOfInput) {
            collectionManager.getCommand(nextline.split(" ")).execute();
        }
    }
}
