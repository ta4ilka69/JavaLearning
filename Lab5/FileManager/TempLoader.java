package FileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class for choosing path where to load collection from.
 */
public class TempLoader {
    /**
     * Path to temporary file.
     */
    private String tempPath;
    /**
     * Args given on the start, args[0] supposed to be path of collection.
     */
    private String[] cPath;
    /**
     * String to print when temporary file chosen.
     */
    private static String tempfile = "Collection will be read from temporary file";
    /**
     * String to print when file given chosen.
     */
    private static String givenfile = "Collection will be read from given file";

    /**
     * Constructor for class, sets fields.
     * @param tempPath sets temporary file path
     * @param cPath sets given file path
     */
    public TempLoader(String tempPath, String[] cPath) {
        this.tempPath = tempPath;
        this.cPath = cPath;
    }

    /**
     * Check files on existing and differences.
     * @return path where collection will be read from
     */
    public String check() {
        Scanner c;
        Scanner temp;
        if (cPath.length < 1) {
            System.out.println(tempfile);
            return tempPath;
        }
        try {
            temp = new Scanner(new File(tempPath));
            c = new Scanner(new File(cPath[0]));
        } catch (FileNotFoundException e) {
            System.out.println(givenfile);
            return cPath[0];
        }
        while (c.hasNext() && temp.hasNext()) {
            if (!temp.nextLine().equals(c.nextLine())) {
                return getAnswer();
            }
        }
        if (!c.hasNext() && temp.hasNext()) {
            System.out.println(tempfile);
            return tempPath;
        }
        System.out.println(givenfile);
        return cPath[0];
    }

    /**
     * If both files exist and there are some differences.
     * @return final path that user choose
     */
    private String getAnswer() {
        String ans = "";
        Scanner scan = new Scanner(System.in);
        while (!ans.equals("y") && !ans.equals("n")) {
            System.out.println("Do you want to restore collection from temporary file? (y/n)");
            ans = scan.nextLine();
        }
        if (ans.equals("y")) {
            System.out.println(tempfile);
            return this.tempPath;
        }
        System.out.println(givenfile);
        return this.cPath[0];
    }
}
