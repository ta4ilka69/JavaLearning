package Commands;

/**
 * Interface that includes execute() and info() methods
 */
public interface Executable {
    /**
     * Something will be executed, probably.
     */
    void execute();

    /**
     * @return what actually is going on when executing
     */
    static String info() {
        return "It works somehow you know...";
    }
}
