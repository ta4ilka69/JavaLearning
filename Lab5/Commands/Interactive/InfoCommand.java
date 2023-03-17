package Commands.Interactive;

import Collection.MyCollection;
import Commands.AbstractCommand;

public class InfoCommand extends AbstractCommand {
    public InfoCommand(MyCollection collection){
        super(collection,null);
    }

    @Override
    public void execute() {
        getCollection().printInfo();
    }

    @Override
    public String toString() {
        return "info";
    }

    public static String info(){
        return "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }
}
