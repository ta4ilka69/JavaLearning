package Commands.Interactive;

import Collection.MyCollection;
import Commands.AbstractCommand;

public class PrintSoundtrackUpCommand extends AbstractCommand {
    public PrintSoundtrackUpCommand(MyCollection collection){
        super(collection,null);
    }
    public String toString(){
        return "print_field_ascending_soundtrack_name";
    }

    public static String info(){
        return "print_field_ascending_soundtrack_name : вывести значения поля soundtrackName всех элементов в порядке возрастания";
    }

    @Override
    public void execute() {
        getCollection().soundUp();
    }
}
