package Collection;

import Commands.AbstractCommand;
import Commands.ElementReader;
import Commands.Interactive.*;
import ElementClasses.Coordinates;
import ElementClasses.HumanBeing;
import ElementClasses.WeaponType;

import java.io.FileNotFoundException;
import java.io.InputStream;
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
        switch (command) {
            case "add" -> {
                ElementReader reader = new ElementReader(scanner, collection, auto);
                HumanBeing h = reader.getElement();
                c = new AddElementCommand(collection, h);
            }
            case "execute"->{
                try {
                    c = new ExecuteScript(collection, commandLine[1]);
                }
                catch (FileNotFoundException e){
                    c = new ErrorCommand("File for executing not found",command);
                }
            }
            case "save"->{
                c = new SaveCommand(collection);
            }
            default -> {
                c = new UnknownCommand(command);
            }

        }
        historyManager.update(c);
        return c;
    }
}
