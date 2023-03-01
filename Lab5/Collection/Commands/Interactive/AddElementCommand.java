package Collection.Commands.Interactive;

import Collection.MyCollection;
import ElementClasses.HumanBeing;

public class AddElementCommand extends AbstractCommand implements Command{
    private MyCollection collection;
    public AddElementCommand(MyCollection collection) {
        super(collection);
    }
    public String info(){
        return "add {element} : добавить новый элемент в коллекцию";
    }
}
