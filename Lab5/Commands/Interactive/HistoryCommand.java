package Commands.Interactive;

import Collection.CollectionManager;
import Commands.AbstractCommand;

public class HistoryCommand extends AbstractCommand {
    private CollectionManager manager;
    public HistoryCommand(CollectionManager manager){
        super(manager.getCollection(),null);
    }

    @Override
    public void execute() {
        manager.history().printLast();
    }

    public static String info(){
        return "history : вывести последние 6 команд (без их аргументов)";
    }

    @Override
    public String toString() {
        return "history";
    }
}
