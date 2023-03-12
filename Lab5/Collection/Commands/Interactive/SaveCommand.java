package Collection.Commands.Interactive;

import Collection.Commands.AbstractCommand;
import Collection.MyCollection;

public class SaveCommand extends AbstractCommand {
    public SaveCommand(MyCollection collection){
        super(collection,null);
    }
    public static String info(){
        return "Saves collection into ";
    }
}
