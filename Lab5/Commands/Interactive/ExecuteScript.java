package Commands.Interactive;

import Commands.AbstractCommand;
import Commands.CommandManager;
import Collection.MyCollection;

import java.io.*;

public class ExecuteScript extends AbstractCommand {

    private FileInputStream input;
    public ExecuteScript(MyCollection collection,String path) throws FileNotFoundException {
        super(collection, null);
        this.input = new FileInputStream(path);
    }

    @Override
    public void execute() {
        CommandManager manager = new CommandManager(this.input,this.getCollection());
        manager.start();
    }
    public static String info(){
        return "";
    }
}
