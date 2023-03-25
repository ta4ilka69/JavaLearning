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

    public CommandManager(InputStream in, MyCollection collection, ReaderMode mode) {
        this.input = in;
        this.scanner = new Scanner(in);
        collectionManager = new CollectionManager(collection,scanner,mode);
    }

    public void start() {
        String nextline = scanner.nextLine();
        while (!nextline.equals("exit")) {
            String[] command = nextline.split(" ");
            collectionManager.getCommand(command).execute();
            if(scanner.hasNext()) {
                nextline = scanner.nextLine();
            }
            new SaveTemp(collectionManager.getCollection()).execute();
        }
        collectionManager.getCommand(nextline.split(" ")).execute();
    }
}
