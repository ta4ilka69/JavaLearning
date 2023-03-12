package FileManager;

import Collection.Commands.Executable;
import Collection.MyCollection;

import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CollectionReader implements Executable {
    private MyCollection collection;
    private Scanner scanner;
    public CollectionReader(String path, MyCollection collection) throws IllegalArgumentException{
        this.collection = collection;
        if(!path.endsWith(".csv")){
            throw new IllegalArgumentException("File must be .csv !!!");
        }
        try {
            this.scanner = new Scanner(new File(path));
        }
        catch (Exception e){
            if(e instanceof FileNotFoundException){
                System.out.println("File for reading does not exist");
            }
        }
    }

    @Override
    public void execute() {
        //make a script in a temp file and execute it
    }

    public static String info() {
        return "Reads collection from CSV file";
    }
}
