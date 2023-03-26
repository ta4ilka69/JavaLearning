package Commands;

import Collection.CollectionManager;
import Collection.MyCollection;
import FileManager.ReaderMode;

import java.io.InputStream;
import java.util.Scanner;

public class CommandManager {
    private InputStream input;
    private Scanner scanner;
    private CollectionManager collectionManager;
    private ReaderMode mode;

    public CommandManager(InputStream in, MyCollection collection, ReaderMode mode) {
        this.input = in;
        this.scanner = new Scanner(in);
        collectionManager = new CollectionManager(collection, scanner, mode);
        this.mode = mode;
    }

    public void start() {
        String nextline = scanner.hasNext() ? scanner.nextLine() : "";
        boolean endOfInput = false;
        while (!nextline.equals("exit")&&(!endOfInput)) {
            String[] command = nextline.split(" ");
            collectionManager.getCommand(command).execute();
            if (scanner.hasNext()) {
                nextline = scanner.nextLine();
            }
            else{
                endOfInput = true;
            }
            new SaveTemp(collectionManager.getCollection()).execute();
        }
        if(!endOfInput) {
            collectionManager.getCommand(nextline.split(" ")).execute();
        }
    }
}
