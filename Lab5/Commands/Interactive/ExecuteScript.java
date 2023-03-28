package Commands.Interactive;

import Commands.AbstractCommand;
import Commands.CommandManager;
import Collection.MyCollection;
import FileManager.ReaderMode;

import java.io.*;
import java.util.Scanner;

public class ExecuteScript extends AbstractCommand {

    private FileInputStream input;
    private ReaderMode mode;
    private int deep;
    public ExecuteScript(MyCollection collection,String path,boolean file, int deep) throws FileNotFoundException {
        super(collection, null);
        this.input = new FileInputStream(path);
        this.mode = file?ReaderMode.FILE:ReaderMode.SCRIPT;
        this.deep = deep;
    }

    @Override
    public void execute() {
        String ans = "";
        if(deep%100==0){
            Scanner console = new Scanner(System.in);
            do{
                System.out.println("Executing deep is" + deep+", if you continue, there could be untraceable StackOverFlow exception, do you want to continue? (y/n)");
                ans = console.nextLine();
            }
            while (!ans.equals("y")&&!ans.equals("n"));
        }
        else{
            ans = "y";
        }
        if(ans.equals("y")) {
            CommandManager manager = new CommandManager(this.input, this.getCollection(), mode, deep);
            manager.start();
        }
    }
    public static String info(){
        return "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    }

    @Override
    public String toString() {
        return "execute";
    }
}
