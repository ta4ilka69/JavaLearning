package Commands.Interactive;

import Collection.MyCollection;
import Commands.AbstractCommand;

public class ShowCommand extends AbstractCommand {
    public ShowCommand(MyCollection collection){
        super(collection,null);
    }

    @Override
    public String toString() {
        return "show";
    }

    @Override
    public void execute() {
        getCollection().show();
    }

    public static String info(){
        return "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
