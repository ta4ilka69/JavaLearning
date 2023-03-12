package Collection;

import Collection.Commands.AbstractCommand;
import Collection.Commands.Interactive.AddElementCommand;
import Collection.Commands.Interactive.ErrorCommand;
import Collection.Commands.Interactive.ExecuteScript;
import Collection.Commands.Interactive.UnknownCommand;
import ElementClasses.Coordinates;
import ElementClasses.HumanBeing;
import ElementClasses.WeaponType;

import java.io.FileNotFoundException;

public class CollectionManager {
    private MyCollection collection;
    private HistoryManager historyManager;
    private static int id = 1;

    public CollectionManager(MyCollection collection) {
        this.collection = collection;
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
                HumanBeing h = new HumanBeing(id,"Name", new Coordinates(3.0F,4.),true,true,3,"sigma", 2.0F, WeaponType.AXE,"Porsche");
                c = new AddElementCommand(collection, h);
                historyManager.update(c);
                return c;
            }
            case "execute"->{
                try {
                    c = new ExecuteScript(collection, commandLine[1]);
                    historyManager.update(c);
                    return c;
                }
                catch (FileNotFoundException e){
                    c = new ErrorCommand("File for executing not found",command);
                    historyManager.update(c);
                    return c;
                }
            }
            default -> {
                c = new UnknownCommand(command);
                historyManager.update(c);
                return c;
            }
        }
    }
}
