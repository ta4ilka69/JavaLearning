package Commands.Interactive;

import Collection.MyCollection;
import Commands.AbstractCommand;
import Commands.SaveTemp;

import java.util.Scanner;

public class ExitCommand extends AbstractCommand {
    private Scanner scanner;
    public ExitCommand(MyCollection collection, Scanner scanner){
        super(collection,null);
        this.scanner = scanner;
    }

    public String toString(){
        return "exit";
    }

    public static String info(){
        return "exit : завершить программу (без сохранения в файл)";
    }

    @Override
    public void execute() {
        System.out.println("Do you want to save collection before exit? (y/n)");
        String line = scanner.nextLine();
        while (!(line.equals("y")||line.equals("n"))){
            System.out.println("Do you want to save collection before exit? (y/n)");
            line = scanner.nextLine();
        }
        if(line.equals("y")){
            SaveCommand c = new SaveCommand(getCollection());
            c.execute();
        }
        else{
            SaveTemp c = new SaveTemp(getCollection());
            c.execute();
        }
    }
}
