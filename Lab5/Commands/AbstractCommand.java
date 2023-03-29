package Commands;

import Collection.MyCollection;
import ElementClasses.HumanBeing;

/**
 * Abstract class for interactive commands.
 * Getters for fields and methods that must be in child class
 * @see Executable
 */
public class AbstractCommand implements Executable {
    /**
     * Collection we are working with.
     * @see MyCollection
     */
    private MyCollection collection;
    /**
     * Element needed for some commands, may be null.
     * @see HumanBeing
     */
    private HumanBeing h;

    /**
     * Constructor for class.
     * @param collection sets collection.
     * @param h element for executing if needed.
     */
    public AbstractCommand(MyCollection collection, HumanBeing h) {
        this.collection = collection;
        this.h = h;
    }

    /**
     * some method.
     */
    public void execute() {
    }

    /**
     * @return what this command is.
     */
    public static String info() {
        return "Abstract Command";
    }


    /**
     * @return element of this command.
     */
    public HumanBeing getElement() {
        return this.h;
    }

    /**
     * @return collection we working with
     */
    public MyCollection getCollection() {
        return collection;
    }

    /**
     * @return name of command
     */
    public String toString() {
        return "Abstract command";
    }
}
