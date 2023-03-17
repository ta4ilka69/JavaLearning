package Commands.Interactive;

import Collection.MyCollection;
import Commands.AbstractCommand;

public class RemoveByIdCommand extends AbstractCommand {
    private int id;
    public RemoveByIdCommand(MyCollection collection, int id){
        super(collection,null);
        this.id = id;
    }

    @Override
    public void execute() {
        getCollection().removeById(id);
    }

    @Override
    public String toString() {
        return "remove_by_id";
    }

    public static String info(){
        return "remove_by_id id : удалить элемент из коллекции по его id";
    }
}
