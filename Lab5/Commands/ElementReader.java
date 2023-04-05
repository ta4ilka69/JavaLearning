package Commands;


import Collection.MyCollection;
import ElementClasses.Car;
import ElementClasses.Coordinates;
import ElementClasses.HumanBeing;
import ElementClasses.WeaponType;
import FileManager.ReaderMode;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Scanner;

/**
 * Class for reading element using scanner. Works with different modes.
 * @see ReaderMode
 * @see HumanBeing
 */
public class ElementReader {
    /**
     * Scanner for reading from source.
     */
    private Scanner scanner;
    /**
     * Readermode field.
     * @see ReaderMode
     */
    private ReaderMode mode;
    /**
     * Collection we working with.
     * @see MyCollection
     */
    private MyCollection collection;
    /**
     *For getting information from user if needed.
     */
    private Scanner interactor = new Scanner(System.in);
    /**
     * Fields of HumanBeing class, for me not to write all field names and types.
     */
    private static Field[] fields = HumanBeing.class.getDeclaredFields();

    /**
     * Constructor for class.
     * @param scanner sets scanner.
     * @param collection sets collection.
     * @param mode sets ReaderMode.
     */

    public ElementReader(Scanner scanner, MyCollection collection, ReaderMode mode) {
        this.scanner = scanner;
        this.collection = collection;
        this.mode = mode;
    }

    /**
     * Gets all fields needed for element.
     * @return HumanBeing object.
     */
    public HumanBeing getElement() {
        Object[] args = new Object[13];
        if (mode == ReaderMode.GREATER) {
            args[0] = getLine(0, "");
        } else if (mode != ReaderMode.FILE || !scanner.hasNext()) {
            args[0] = this.collection.getFreeId();
        } else {
            args[0] = getField(0, scanner.nextLine());
        }
        for (int i = 1; i < 13; i++) {
            if (i == 4 && ReaderMode.GREATER != mode) {
                if (mode != ReaderMode.FILE || !scanner.hasNext()) {
                    args[4] = new Date();
                } else {
                    args[4] = getField(i, scanner.nextLine());
                }
            } else if (mode != ReaderMode.CONSOLE && mode != ReaderMode.GREATER) {
                if (i == 12 && (mode == ReaderMode.FILE || mode==ReaderMode.SCRIPT) && scanner.hasNext()) {
                    args[i] = getField(13, scanner.nextLine());
                } else if (i != 12 && scanner.hasNext()) {
                    args[i] = getField(i, scanner.nextLine());
                }
            } else {
                args[i] = getLine(i, "");
            }
        }
        Boolean tooth;
        if (args[6] != null) {
            tooth = (boolean) args[6];
        } else {
            tooth = null;
        }
        HumanBeing h = new HumanBeing((int) args[0], (String) args[1], new Coordinates((double) args[2], (long) args[3]), (Boolean) args[5], tooth, (Float) args[7], (String) args[8], (double) args[9], (WeaponType) args[10], (String) args[11]);
        if (args[12] != null) {
            Car c = new Car((String) args[11]);
            c.setCool((boolean) args[12]);
            h.setCar(c);
        }
        if (ReaderMode.FILE == mode) {
            h.setCreationDate((Date) args[4]);
        }
        return h;
    }

    /**
     * Gets some fields from user and print, if something went wrong.
     * @param arg the index of field we need to get.
     * @param err prints if something went wrong on previous stage.
     * @return recursively invoke another method to get object (with type as field[arg]).
     */
    private Object getLine(int arg, String err) {
        if (err.length() != 0) {
            System.out.println(err);
        }
        switch (arg) {
            case 0, 1 -> System.out.println("Enter " + fields[arg].getName() + ": ");
            case 2, 3 ->
                    System.out.println("Enter " + fields[2].getType().getDeclaredFields()[arg - 2].getName() + ": ");
            case 10 ->
                    System.out.println("Enter " + fields[9].getName() + " (choose from " + WeaponType.AXE + ", " + WeaponType.RIFLE + ", " + WeaponType.MACHINE_GUN + "): ");
            case 12 ->
                    System.out.println("Do you want to set your car cool (it wouldn`t make your car cool anyway) (y/n)?");
            case 13 -> System.out.println("Enter " + fields[10].getType().getDeclaredFields()[1].getName() + ": ");
            case 11 -> System.out.println("Enter " + fields[10].getType().getDeclaredFields()[0].getName() + ": ");
            case 4 -> System.out.println("Enter date (ms from 01.01.1970): ");
            default -> System.out.println("Enter " + fields[arg - 1].getName() + ": ");
        }
        return getField(arg, interactor.nextLine());
    }

    /**
     * Parse fields from string to object.
     * @param i index of field we need to parse.
     * @param line string for parsing.
     * @return object of field[i] or recursively invoke another method to get right line from user to parse.
     */
    private Object getField(int i, String line) {
        switch (i) {
            case 0 -> {
                try {
                    int id = Integer.parseInt(line);
                    if (id < 1) {
                        throw new NumberFormatException();
                    } else {
                        return id;
                    }
                } catch (NumberFormatException e) {
                    if (ReaderMode.GREATER != mode) {
                        return this.collection.getFreeId();
                    }
                    return getLine(i, "id must be integer!");
                }
            }
            case 1, 8, 11 -> {
                if (line.length() == 0 && i != 11) {
                    int arg = i == 8 ? 7 : i;
                    return getLine(i, fields[arg].getName() + " can`t be empty!");
                }
                return line;
            }
            case 2 -> {
                try {
                    double x = Double.parseDouble(line);
                    return x > 316 ? getLine(i, fields[i].getName() + " must be less than 316!") : x;
                } catch (NumberFormatException e) {
                    return getLine(i, fields[2].getType().getDeclaredFields()[i - 2].getName() + " must be " + fields[2].getType().getDeclaredFields()[i - 2].getGenericType().getTypeName() + "!");
                }
            }
            case 3 -> {
                try {
                    long y = Long.parseLong(line);
                    return y;
                } catch (NumberFormatException e) {
                    return getLine(i, fields[2].getType().getDeclaredFields()[i - 2].getName() + " must be " + fields[2].getType().getDeclaredFields()[i - 2].getGenericType().getTypeName() + "!");
                }
            }
            case 5, 6 -> {
                if (line.length() == 0 && i == 6) {
                    return null;
                }
                if (line.equals("true") || line.equals("false")) {
                    return Boolean.parseBoolean(line);
                } else {
                    return getLine(i, fields[i - 1].getName() + " must be " + fields[i - 1].getGenericType().getTypeName() + "!");
                }
            }
            case 7 -> {
                try {
                    Float speed = Float.parseFloat(line);
                    return speed;
                } catch (NumberFormatException e) {
                    return getLine(i, fields[i - 1].getName() + " must be " + fields[i - 1].getGenericType().getTypeName() + "!");
                }
            }
            case 9 -> {
                try {
                    double minutes = Double.parseDouble(line);
                    return minutes;
                } catch (NumberFormatException e) {
                    return getLine(i, fields[i - 1].getName() + " must be " + fields[i - 1].getGenericType().getTypeName() + "!");
                }
            }
            case 10 -> {
                if (line.length() == 0) {
                    return getLine(10,"Can`t be null");
                }
                if (line.equals(WeaponType.AXE.toString()) || line.equals(WeaponType.RIFLE.toString()) || line.equals(WeaponType.MACHINE_GUN.toString())) {
                    return WeaponType.valueOf(line);
                } else {
                    return getLine(i, fields[i - 1].getName() + " must be " + fields[i - 1].getGenericType().getTypeName() + "!");
                }
            }
            case 4 -> {
                try {
                    return new Date(Long.parseLong(line));
                } catch (Exception e) {
                    if (ReaderMode.GREATER != mode) {
                        return new Date();
                    }
                    return getLine(i, "Ms from 01.01.1970 must be integer!");
                }
            }
            case 12 -> {
                if (line.equals("y")) {
                    return getLine(13, "");
                } else if (line.equals("n")) {
                    return null;
                } else {
                    return getLine(i, "You must enter y or n!");
                }
            }
            case 13 -> {
                if (line.equals("true") || line.equals("false")) {
                    return Boolean.parseBoolean(line);
                } else {
                    return getLine(i, "You must enter true or false!");
                }
            }
            default -> {
                return null;
            }
        }
    }
}
