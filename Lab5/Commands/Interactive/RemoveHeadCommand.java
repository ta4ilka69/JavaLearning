package Commands.Interactive;

import Collection.MyCollection;
import Commands.AbstractCommand;

public class RemoveHeadCommand extends AbstractCommand {
    public RemoveHeadCommand(MyCollection collection) {
        super(collection, null);
    }

    @Override
    public void execute() {
        getCollection().removeHead();
    }

    public String toString() {
        return "remove_head";
    }

    public static String info() {
        return "remove_head : вывести первый элемент коллекции и удалить его";
    }
}
