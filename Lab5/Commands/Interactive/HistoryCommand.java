package Commands.Interactive;

import Collection.HistoryManager;
import Collection.MyCollection;
import Commands.AbstractCommand;

public class HistoryCommand extends AbstractCommand {
    private HistoryManager manager;
    public HistoryCommand(HistoryManager manager, MyCollection collection){
        super(collection,null);
        this.manager = manager;
    }

    @Override
    public void execute() {
        this.manager.printLast();
    }

    public static String info(){
        return "history : вывести последние 6 команд (без их аргументов)";
    }

    @Override
    public String toString() {
        return "history";
    }
}
