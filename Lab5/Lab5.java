import Commands.CommandManager;
import Collection.MyCollection;
import FileManager.CollectionReader;
import FileManager.ReaderMode;
import FileManager.TempLoader;

public class Lab5 {
    /**
     * @param args
     * Entry point of the program
     * Initialize
     */
    public static void main(String[] args) {
        TempLoader load = new TempLoader("tmp/temp.csv",args[0]);
        MyCollection c = new MyCollection(load.check());
        CollectionReader reader = new CollectionReader(c);
        reader.execute();
        c.setPathToSave(args[0]);
        System.out.println("Collection was read from file");
        CommandManager in = new CommandManager(System.in,c, ReaderMode.CONSOLE,0);
        in.start();
    }
}
