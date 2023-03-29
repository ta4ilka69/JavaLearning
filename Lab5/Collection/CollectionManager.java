package Collection;

import Commands.AbstractCommand;
import Commands.CarReader;
import Commands.ElementReader;
import Commands.Interactive.*;
import ElementClasses.HumanBeing;
import FileManager.ReaderMode;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class that works with collection and identify commands.
 * @see MyCollection
 */
public class CollectionManager {
    /**
     * collection we are working with.
     */
    private MyCollection collection;
    /**
     * History manager.
     * @see HistoryManager
     */
    private HistoryManager historyManager;
    /**
     * Scanner for reading commands.
     */
    private Scanner scanner;
    /**
     * ReaderMode for executing.
     * @see ReaderMode
     */
    private ReaderMode mode;
    /**
     * Depth of executing commands. To control recursion depth.
     */

    private int deep;

    /**
     * Initialize object.
     * @param collection sets collection.
     * @param scanner sets scanner,
     * @param mode sets mode.
     * @param deep sets depth.
     */

    public CollectionManager(MyCollection collection, Scanner scanner, ReaderMode mode, int deep) {
        this.collection = collection;
        this.scanner = scanner;
        this.mode = mode;
        this.historyManager = new HistoryManager(6);
        this.deep = deep;
    }

    /**
     * Getter for collection.
     * @return collection.
     */
    public MyCollection getCollection() {
        return collection;
    }

    /**
     * Parse line into command.
     * @param commandLineRaw line for parsing.
     * @return some command that extends AbstractCommand
     * @see AbstractCommand
     */
    public AbstractCommand getCommand(String[] commandLineRaw) {
        String command = commandLineRaw[0];
        String[] commandLine;
        if (commandLineRaw.length == 1) {
            commandLine = new String[]{commandLineRaw[0], ""};
        } else {
            commandLine = commandLineRaw;
        }
        AbstractCommand c;
        c = switch (command) {
            case "add" -> {
                ElementReader reader = new ElementReader(scanner, collection, mode);
                HumanBeing h = reader.getElement();
                yield new AddElementCommand(collection, h);
            }
            case "execute" -> {
                try {
                    yield new ExecuteScript(collection, commandLine[1], false, deep + 1);
                } catch (FileNotFoundException e) {
                    yield new ErrorCommand("File for executing not found", command);
                }
            }
            case "help" -> new HelpCommand();
            case "exit" -> new ExitCommand(collection, scanner, mode);
            case "save" -> new SaveCommand(collection);
            case "remove_head" -> new RemoveHeadCommand(collection);
            case "remove_greater" -> {
                ElementReader reader = new ElementReader(scanner, collection, ReaderMode.GREATER);
                yield new RemoveGreaterCommand(collection, reader.getElement());
            }
            case "remove_by_id" -> {
                int id;
                try {
                    id = Integer.parseInt(commandLine[1]);
                    yield new RemoveByIdCommand(collection, id);
                } catch (NumberFormatException e) {
                    yield new ErrorCommand("id not found or id must be integer", "remove_by_id");
                }
            }
            case "count_greater_than_car" -> {
                CarReader reader = new CarReader(System.in);
                yield new CountGreaterThanCarCommand(collection, reader.getCar());
            }
            case "history" -> new HistoryCommand(this.historyManager, collection);
            case "info" -> new InfoCommand(collection);
            case "show" -> new ShowCommand(collection);
            case "print_descending" -> new PrintDescendingCommand(collection);
            case "print_field_ascending_soundtrack_name" -> new PrintSoundtrackUpCommand(collection);
            case "update" -> {
                int id;
                try {
                    id = Integer.parseInt(commandLine[1]);
                    if (this.collection.getElementById(id) == null) {
                        throw new NumberFormatException();
                    }
                    ElementReader reader = new ElementReader(scanner, collection, mode);
                    yield new UpdateCommand(collection, reader.getElement(), id);
                } catch (NumberFormatException e) {
                    yield new ErrorCommand("id not found or id must be integer", "update");
                }
            }
            case "clear" -> new ClearCommand(collection);
            default -> new UnknownCommand(command);

        };
        historyManager.update(c);
        return c;
    }

    /**
     * @return history manager.
     */
    public HistoryManager history() {
        return this.historyManager;
    }
}
