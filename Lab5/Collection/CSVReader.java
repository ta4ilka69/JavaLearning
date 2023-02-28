package Collection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class CSVReader {
    private File file;
    public CSVReader(String path) {
        this.file = new File(path);
    }

    public void read(MyCollection c) throws FileNotFoundException{
        Scanner scan = new Scanner(this.file);
        c.clear();
        String nextLine = scan.nextLine();
        while (nextLine != null) {
            String[] t = (nextLine.split(","));
            for (String tt : t
            ) {
                c.add(tt);
            }
            nextLine = scan.nextLine();
        }
    }
}
