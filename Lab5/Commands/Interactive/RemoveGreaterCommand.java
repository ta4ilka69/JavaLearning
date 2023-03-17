package Commands.Interactive;

import Collection.MyCollection;
import Commands.AbstractCommand;
import ElementClasses.HumanBeing;


public class RemoveGreaterCommand extends AbstractCommand {
    public RemoveGreaterCommand(MyCollection collection, HumanBeing h){
        super(collection,h);
    }

    @Override
    public void execute() {
        getCollection().removeGreater(getElement());
    }

    @Override
    public String toString() {
        return "remove_greater";
    }

    public static String info(){
        return "remove_greater {element} : удалить из коллекции все элементы, превышающие заданный";
    }
}
