package FileManager;

import Collection.MyCollection;
import Commands.Executable;
import ElementClasses.Coordinates;
import ElementClasses.HumanBeing;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 *Class for writing collection into CSV file.
 * @see Executable
 */
public class CollectionWriter implements Executable {
    /**
     *Path to file for saving.
     */
    private String pathToFile;
    /**
     * Collection we are working with.
     * @see MyCollection
     */
    private MyCollection collection;

    /**
     * Constructor for class.
     * @param collection sets collection and pathToFile.
     */
    public CollectionWriter(MyCollection collection) {
        this.collection = collection;
        this.pathToFile = collection.getPathToSave();
    }

    /**
     * Writes collection into file (path given in field).
     * @see HumanBeing
     * @see ElementClasses.Car
     * @see Coordinates
     * @see ElementClasses.WeaponType
     */
    public void execute() {
        try {
            FileOutputStream file = new FileOutputStream(pathToFile);
            OutputStreamWriter writer = new OutputStreamWriter(file);
            HumanBeing[] list = collection.list();
            for (int i = 0; i < list.length; i++) {
                HumanBeing h = list[i];
                String s = h.getId().toString() + ',';
                String name = h.getName();
                s += screening(name);
                s += ',';
                Coordinates c = h.getCoordinates();
                s += c.xToString();
                s += ',';
                s += c.yToString();
                s += ',';
                s += h.getCreationDate().getTime();
                s += ',';
                s += h.getRealHero().toString();
                s += ',';
                String tooth = h.getHasToothpick() == null ? "" : h.getHasToothpick().toString();
                s += tooth;
                s += ',';
                s += h.getImpactSpeed().toString();
                s += ',';
                String sound = h.getSoundtrackName();
                s += screening(sound);
                s += ',';
                s += Double.toString(h.getMinutesOfWaiting());
                s += ',';
                String weapon = h.getWeaponType() == null ? "" : h.getWeaponType().toString();
                s += weapon;
                s += ',';
                String car = h.getCar().getCarName();
                s += screening(car);
                s += ',';
                s += Boolean.toString(h.getCar().isCool());
                if (i != list.length - 1) {
                    s += '\n';
                }
                writer.write(s);
            }
            writer.close();
        } catch (Exception e) {
            if (e instanceof FileNotFoundException) {
                System.out.println("\u001B[31m WARNING \u001B[0m File with collection was stolen!!!");
            }
        }
    }

    /**
     *If commas or double quotes are in string, take them into double quotes on left and on right.
     * @param s string for screening
     * @return string with screened quotes and commas
     */
    private String screening(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ',' || s.charAt(i) == '"') {
                res += "\"" + s.charAt(i) + "\"";
            } else {
                res += s.charAt(i);
            }
        }
        return res;
    }

    /**
     * @return what executing is actually doing
     */
    public static String info() {
        return "Writes collection to file";
    }
}
