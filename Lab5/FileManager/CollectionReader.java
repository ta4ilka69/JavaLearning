package FileManager;

import Commands.Executable;
import Collection.MyCollection;
import Commands.Interactive.ExecuteScript;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class CollectionReader implements Executable {
    private MyCollection collection;
    private Scanner scanner;

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
                    for(int j = 0;j<13;j++){
                        if(j!=1&&j!=8&&j!=11){
                            while(i<line.length()&&line.charAt(i)!=','){
                                t+=line.charAt(i);
                                i+=1;
                            }
                        }
                        else{
                            boolean screening = false;
                            while(i<line.length()&&(line.charAt(i)!=','||screening)){
                                if(line.charAt(i)=='"'){
                                    screening = !screening;
                                    i++;
                                    if(screening){
                                        t+=line.charAt(i);
                                        i++;
                                    }
                                }
                                else{
                                    t+=line.charAt(i);
                                    i++;
                                }
                            }
                        }
                        writer.write(t);
                        if(j!=12)
                            writer.write("\n");
                        t = "";
                        i+=1;
                    }
                }
                writer.close();
                ExecuteScript script = new ExecuteScript(this.collection,"tmp/reading_script" + u + ".txt",false);
                script.execute();
            } catch (Exception e) {
                u += 1;
            }
        }
    }

    public static String info() {
        return "Reads collection from CSV file";
    }
}
