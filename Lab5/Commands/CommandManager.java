package Commands;

import Collection.CollectionManager;
import Collection.MyCollection;

import java.io.InputStream;
import java.util.Scanner;

public class CommandManager {
    private InputStream input;
    private Scanner scanner;
    private CollectionManager collectionManager;

    public CommandManager(InputStream in, MyCollection collection) {
        this.input = in;
        this.scanner = new Scanner(in);
        collectionManager = new CollectionManager(collection);
    }

    public void start() {
        String nextline = scanner.nextLine();
        while (!nextline.equals("exit")) {
            String[] command = nextline.split(" ");
            collectionManager.getCommand(command).execute();
            nextline = scanner.nextLine();
        }
    }
}
