import Commands.CommandManager;
import Collection.MyCollection;
import FileManager.CollectionReader;
import FileManager.ReaderMode;

public class Lab5 {
    public static void main(String[] args) {
        MyCollection c = new MyCollection(args[0]);
        CollectionReader reader = new CollectionReader(c);
        reader.execute();
        System.out.println("Collection was read from file");
        CommandManager in = new CommandManager(System.in,c, ReaderMode.CONSOLE);
        in.start();
    }
}
