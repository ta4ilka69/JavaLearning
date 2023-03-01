package Collection.Commands.Interactive;

import Collection.Commands.AbstractCommand;
import Collection.Commands.Command;
import Collection.MyCollection;
import ElementClasses.HumanBeing;

public class AddElementCommand extends AbstractCommand implements Command {
    private MyCollection collection;
    private HumanBeing elementToAdd;
    public AddElementCommand(MyCollection collection, HumanBeing h) {
        super(collection);
        this.elementToAdd = h;
    }

    public void execute() {
        this.collection.add(this.elementToAdd);
    }

    public String info(){
        return "add {element} : добавить новый элемент в коллекцию";
    }
}
