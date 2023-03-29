package Commands.Interactive;

import Collection.MyCollection;
import Commands.AbstractCommand;
import ElementClasses.HumanBeing;

public class UpdateCommand extends AbstractCommand {
    private int id;

    public UpdateCommand(MyCollection collection, HumanBeing h, int id) {
        super(collection, h);
        this.id = id;
    }

    public String toString() {
        return "update";
    }

    public static String info() {
        return "update id {element} : обновить значение элемента коллекции, id которого равен заданному";
    }

    @Override
    public void execute() {
        getCollection().update(getElement(), id);
    }
}
