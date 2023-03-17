package Commands.Interactive;

import Collection.MyCollection;
import Commands.AbstractCommand;

public class ClearCommand extends AbstractCommand {
    public ClearCommand(MyCollection collection){
        super(collection,null);
    }

    @Override
    public void execute() {
        getCollection().clear();
    }

    @Override
    public String toString() {
        return "clear";
    }

    public static String info(){
        return "clear : очистить коллекцию";
    }
}
