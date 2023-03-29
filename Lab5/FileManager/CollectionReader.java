package FileManager;

import Collection.MyCollection;
import Commands.Executable;
import Commands.Interactive.ExecuteScript;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * Class for reading collection from CSV file.
 * @see Executable
 */
public class CollectionReader implements Executable {
    /**
     * Collection we working with.
     */
    private MyCollection collection;
    /**
     * @see Scanner
     * Scanner class for reading elements from file.
     */
    private Scanner scanner;

    /**
     * Constructor for class, sets fields.
     * @param collection sets collection.
     * @throws IllegalArgumentException when file is not CSV or does not exist.
     * @see MyCollection
     */
    public CollectionReader(MyCollection collection) throws IllegalArgumentException {
        this.collection = collection;
        String path = collection.getPathToSave();
        if (!path.endsWith(".csv")) {
            throw new IllegalArgumentException("File must be .csv !!!");
        }
        try {
            this.scanner = new Scanner(new File(path));
        } catch (Exception e) {
            if (e instanceof FileNotFoundException) {
                System.out.println("File for reading does not exist");
            }
        }

    }

    /**
     * @see Executable
     * Makes script in temporary .txt file using add command and execute it.
     * @see ExecuteScript
     * @see Commands.Interactive.AddElementCommand
     */
    @Override
    public void execute() {
        int u = 0;
        boolean created = false;
        while (!created) {
            try {
                OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("tmp/reading_script" + u + ".txt"));
                created = true;
                while (this.scanner.hasNext()) {
                    writer.write("add\n");
                    String line = this.scanner.nextLine();
                    String t = "";
                    int i = 0;
                    for (int j = 0; j < 13; j++) {
                        if (j != 1 && j != 8 && j != 11) {
                            while (i < line.length() && line.charAt(i) != ',') {
                                t += line.charAt(i);
                                i += 1;
                            }
                        } else {
                            boolean screening = false;
                            while (i < line.length() && (line.charAt(i) != ',' || screening)) {
                                if (line.charAt(i) == '"') {
                                    screening = !screening;
                                    i++;
                                    if (screening) {
                                        t += line.charAt(i);
                                        i++;
                                    }
                                } else {
                                    t += line.charAt(i);
                                    i++;
                                }
                            }
                        }
                        writer.write(t);
                        if (j != 12 || scanner.hasNext())
                            writer.write("\n");
                        t = "";
                        i += 1;
                    }
                }
                writer.write("\nexit");
                writer.close();
                ExecuteScript script = new ExecuteScript(this.collection, "tmp/reading_script" + u + ".txt", true, 1);
                script.execute();
                System.out.println("Collection was read from file");
            } catch (Exception e) {
                u += 1;
            }
        }
    }

    /**
     * @return description of class function.
     */
    public static String info() {
        return "Reads collection from CSV file";
    }
}
