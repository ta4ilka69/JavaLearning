package Commands.Interactive;

import Collection.MyCollection;
import Commands.AbstractCommand;
import Commands.CommandManager;
import FileManager.ReaderMode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Execute command.
 * @see AbstractCommand
 */
public class ExecuteScript extends AbstractCommand {
    /**
     * Input source of script.
     */

    private FileInputStream input;
    /**
     * ReaderMode od executing.
     * @see ReaderMode
     */
    private ReaderMode mode;
    /**
     * Depth of executing scripts. Needed for infinity recursion defining.
     */
    private int deep;

    /**
     * Initialize command.
     * @param collection sets collection.
     * @param path sets path to script.
     * @param file sets file.
     * @param deep sets depth.
     * @throws FileNotFoundException when file doesn't exist.
     */
    public ExecuteScript(MyCollection collection, String path, boolean file, int deep) throws FileNotFoundException {
        super(collection, null);
        this.input = new FileInputStream(path);
        this.mode = file ? ReaderMode.FILE : ReaderMode.SCRIPT;
        this.deep = deep;
    }

    /**
     * Invoke new CommandManager to deal with script. Check the depth of executing.
     * @see CommandManager
     * @throws StackOverflowError when depth of executing is too high (~ >2000).
     */
    @Override
    public void execute() {
        String ans = "";
        if (deep % 1000 == 0) {
            Scanner console = new Scanner(System.in);
            do {
                System.out.println("Executing deep is " + deep + ", if you continue, there could be untraceable StackOverFlow error, do you want to continue? (y/n)");
                ans = console.nextLine();
            }
            while (!ans.equals("y") && !ans.equals("n"));
        } else {
            ans = "y";
        }
        if (ans.equals("y")) {
            CommandManager manager = new CommandManager(this.input, this.getCollection(), mode, deep);
            try {
                manager.start();
            }
            catch (StackOverflowError e){
                if(deep==1) {
                    System.out.println("You weren`t listening, were you?\n\u001B[31mStackOverFlowError\u001B[0m because of infinity script executing, nice bro!\nI don`t want to work with you actually, see you later!");
                }
                throw new StackOverflowError();
            }
        }
    }
    /**
     * @return information for "help" command.
     */
    public static String info() {
        return "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    }
    /**
     * @return name of command.
     */
    @Override
    public String toString() {
        return "execute";
    }
}
