import Collection.MyCollection;
import Commands.CommandManager;
import Commands.Interactive.ExitCommand;
import FileManager.CollectionReader;
import FileManager.ReaderMode;
import FileManager.TempLoader;

import java.util.Scanner;

/**
 * Main class of programm.
 * Consist of main() method.
 * Lab5.
 * @author ta4ilka69
 * @version 8.3
 */
public class Lab5 {
    /**
     * Entry point of the programm.
     * @param args at index 0 is supposed to be a path to file.
     * @see TempLoader
     * @see MyCollection
     * @see CollectionReader
     * @see CommandManager
     * @see ReaderMode
     */
    public static void main(String[] args) {
        TempLoader load = new TempLoader("tmp/temp.csv", args);
        MyCollection c = new MyCollection(load.check());
        CollectionReader reader = new CollectionReader(c);
        reader.execute();
        if (args.length < 1) {
            c.setPathToSave("1.csv");
        } else {
            c.setPathToSave(args[0]);
        }
        CommandManager in = new CommandManager(System.in, c, ReaderMode.CONSOLE, 0);
        try {
            in.start();
        }
        catch (StackOverflowError e){
            new ExitCommand(c,new Scanner(System.in),ReaderMode.CONSOLE).execute();
        }
    }
}
