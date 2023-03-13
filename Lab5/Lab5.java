import Commands.CommandManager;
import Collection.MyCollection;
import FileManager.CollectionReader;

public class Lab5 {
    public static void main(String[] args) {
        MyCollection c = new MyCollection(args[0]);
        CollectionReader reader = new CollectionReader(c);
        reader.execute();
        CommandManager in = new CommandManager(System.in,c);
        in.start();
    }
}
