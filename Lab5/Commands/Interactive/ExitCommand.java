package Commands.Interactive;

import Collection.MyCollection;
import Commands.AbstractCommand;
import Commands.SaveTemp;
import FileManager.ReaderMode;

import java.util.Scanner;

public class ExitCommand extends AbstractCommand {
    private Scanner scanner;
    private ReaderMode mode;
    public ExitCommand(MyCollection collection, Scanner scanner,ReaderMode mode){
        super(collection,null);
        this.scanner = scanner;
        this.mode = mode;
    }

    public String toString(){
        return "exit";
    }

    public static String info(){
        return "exit : завершить программу (без сохранения в файл)";
    }

    @Override
    public void execute() {
        if(mode == ReaderMode.CONSOLE) {
            System.out.println("Do you want to save collection before exit? (y/n)");
            String line = scanner.nextLine();
            while (!(line.equals("y") || line.equals("n"))) {
                System.out.println("Do you want to save collection before exit? (y/n)");
                line = scanner.nextLine();
            }
            if (line.equals("y")) {
                SaveCommand c = new SaveCommand(getCollection());
                c.execute();
            } else {
                SaveTemp c = new SaveTemp(getCollection());
                c.execute();
            }
        }
        else {
            SaveTemp c = new SaveTemp(getCollection());
            c.execute();
        }
    }
}
