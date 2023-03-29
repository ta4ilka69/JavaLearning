package Commands.Interactive;

import Collection.MyCollection;
import Commands.AbstractCommand;
import Commands.SaveTemp;
import FileManager.ReaderMode;

import java.util.Scanner;

/**
 * Command for saving collection before closing only
 * @see AbstractCommand
 */
public class ExitCommand extends AbstractCommand {
    /**
     * Scanner for reading from console.
     */
    private Scanner scanner;
    /**
     * ReaderMode.
     * @see ReaderMode
     */
    private ReaderMode mode;

    /**
     * Initialize command.
     * @param collection sets collection.
     * @param scanner sets scanner.
     * @param mode sets ReaderMode.
     */

    public ExitCommand(MyCollection collection, Scanner scanner, ReaderMode mode) {
        super(collection, null);
        this.scanner = scanner;
        this.mode = mode;
    }
    /**
     * @return name of command.
     */
    public String toString() {
        return "exit";
    }
    /**
     * @return information for "help" command.
     */
    public static String info() {
        return "exit : завершить программу (без сохранения в файл)";
    }

    /**
     * Ask user if he wants to save collection before quiting. Makes SaveTemp command.
     * @see SaveTemp
     * @see SaveCommand
     */
    @Override
    public void execute() {
        if (mode == ReaderMode.CONSOLE) {
            System.out.println("Do you want to save collection before exit? (y/n)");
            String line = scanner.nextLine();
            while (!(line.equals("y") || line.equals("n"))) {
                System.out.println("Do you want to save collection before exit? (y/n)");
                line = scanner.nextLine();
            }
            if (line.equals("y")) {
                SaveCommand c = new SaveCommand(getCollection());
                c.execute();
            } else {
                SaveTemp c = new SaveTemp(getCollection());
                c.execute();
            }
        } else {
            SaveTemp c = new SaveTemp(getCollection());
            c.execute();
        }
    }
}
