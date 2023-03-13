package Commands.Interactive;

import Commands.AbstractCommand;
import Collection.MyCollection;
import ElementClasses.HumanBeing;

public class AddElementCommand extends AbstractCommand{
    public AddElementCommand(MyCollection collection, HumanBeing h) {
        super(collection,h);
    }

    public void execute() {
        super.getCollection().add(super.getElement());
    }

    public static String info(){
        return "add {element} : добавить новый элемент в коллекцию";
    }
}
