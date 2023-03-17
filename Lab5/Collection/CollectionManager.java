package Collection;

import Commands.AbstractCommand;
import Commands.CarReader;
import Commands.ElementReader;
import Commands.Interactive.*;
import ElementClasses.HumanBeing;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class CollectionManager {
    private MyCollection collection;
    private HistoryManager historyManager;
    private Scanner scanner;
    private boolean auto;


    public CollectionManager(MyCollection collection, Scanner scanner, boolean auto){
        this.collection = collection;
        this.scanner = scanner;
        this.auto = auto;
        this.historyManager = new HistoryManager(6);
    }

    public MyCollection getCollection() {
        return collection;
    }
    public AbstractCommand getCommand(String[] commandLine){
        String command = commandLine[0];
        AbstractCommand c;
        c = switch (command) {
            case "add" -> {
                ElementReader reader = new ElementReader(scanner, collection, auto);
                HumanBeing h = reader.getElement();
                yield new AddElementCommand(collection, h);
            }
            case "execute"->{
                try {
                    yield  new ExecuteScript(collection, commandLine[1],true);
                }
                catch (FileNotFoundException e){
                    yield  new ErrorCommand("File for executing not found",command);
                }
            }
            case "help"-> new HelpCommand();
            case "exit"-> new ExitCommand(collection,scanner);
            case "save"-> new SaveCommand(collection);
            case "remove_head"-> new RemoveHeadCommand(collection);
            case "remove_greater"->{
                ElementReader reader = new ElementReader(scanner,collection,true);
                yield new RemoveGreaterCommand(collection,reader.getElement());
            }
            case "remove_by_id"->{
                int id;
                try{
                    id = Integer.parseInt(commandLine[1]);
                    yield new RemoveByIdCommand(collection,id);
                }
                catch (NumberFormatException e){
                    yield new ErrorCommand("id not found or id must be integer","remove_by_id");
                }
            }
            case "count_greater_than_car"->{
                CarReader reader = new CarReader(System.in);
                yield new CountGreaterThanCarCommand(collection,reader.getCar());
            }
            case "history"-> new HistoryCommand(this);
            case "info"-> new InfoCommand(collection);
            case "show"-> new ShowCommand(collection);
            case "print_descending"-> new PrintDescendingCommand(collection);
            case "print_field_ascending_soundtrack_name"-> new PrintSoundtrackUpCommand(collection);
            case "update"->{
                int id;
                try {
                    id = Integer.parseInt(commandLine[1]);
                    ElementReader reader = new ElementReader(scanner,collection,auto);
                    yield new UpdateCommand(collection,reader.getElement(),id);
                }
                catch (NumberFormatException e){
                    yield  new ErrorCommand("id not found or id must be integer","update");
                }
            }
            case "clear"-> new ClearCommand(collection);
            default -> new UnknownCommand(command);

        };
        historyManager.update(c);
        return c;
    }
    public HistoryManager history(){
        return this.historyManager;
    }
}
