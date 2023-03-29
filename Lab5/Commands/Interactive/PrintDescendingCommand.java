package Commands.Interactive;

import Collection.MyCollection;
import Commands.AbstractCommand;

public class PrintDescendingCommand extends AbstractCommand {
    public PrintDescendingCommand(MyCollection collection) {
        super(collection, null);
    }

    @Override
    public void execute() {
        getCollection().printDescending();
    }

    public String toString() {
        return "print_descending";
    }

    public static String info() {
        return "print_descending : вывести элементы коллекции в порядке убывания";
    }
}
