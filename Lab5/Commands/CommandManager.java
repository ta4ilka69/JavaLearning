package Commands;

import Collection.CollectionManager;
import Collection.MyCollection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class CommandManager {
    private InputStream input;
    private Scanner scanner;
    private CollectionManager collectionManager;

    public CommandManager(InputStream in, MyCollection collection) {
        this.input = in;
        this.scanner = new Scanner(in);
        boolean auto = true;
        if(in instanceof FileInputStream){
            try {
                auto = in.equals(new FileInputStream(collection.getPathToSave()));
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        collectionManager = new CollectionManager(collection,scanner,auto);
    }

    public void start() {
        String nextline = scanner.nextLine();
        while (!nextline.equals("exit")) {
            String[] command = nextline.split(" ");
            collectionManager.getCommand(command).execute();
            if(scanner.hasNext()) {
                nextline = scanner.nextLine();
            }
            else {
                break;
            }
        }
    }
}
