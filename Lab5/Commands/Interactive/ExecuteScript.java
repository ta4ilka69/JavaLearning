package Commands.Interactive;

import Commands.AbstractCommand;
import Commands.CommandManager;
import Collection.MyCollection;
import FileManager.ReaderMode;

import java.io.*;

public class ExecuteScript extends AbstractCommand {

    private FileInputStream input;
    private ReaderMode mode;
    public ExecuteScript(MyCollection collection,String path,boolean file) throws FileNotFoundException {
        super(collection, null);
        this.input = new FileInputStream(path);
        this.mode = file?ReaderMode.FILE:ReaderMode.SCRIPT;
    }

    @Override
    public void execute() {
        CommandManager manager = new CommandManager(this.input,this.getCollection(), mode);
        manager.start();
    }
    public static String info(){
        return "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    }

    @Override
    public String toString() {
        return "execute";
    }
}
