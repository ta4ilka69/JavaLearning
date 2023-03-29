package Collection;

import Commands.AbstractCommand;

import java.util.ArrayList;

/**
 * Class for managing history of commands.
 * @see AbstractCommand
 */
public class HistoryManager {
    /**
     * Array to save commands.
     */
    private ArrayList<AbstractCommand> history;
    /**
     * Length of history.
     */
    private int length;

    /**
     * Initialize object.
     * @param length sets length.
     */

    public HistoryManager(int length) {
        this.history = new ArrayList<>();
        this.length = length;
    }

    /**
     * Adding new command into array and delete first, if length is less.
     * @param c new command
     */
    public void update(AbstractCommand c) {
        if (this.history.size() < this.length) {
            this.history.add(c);
        } else {
            this.history.remove(0);
            this.history.add(c);
        }
    }

    /**
     * @return array of commands.
     */
    public ArrayList<AbstractCommand> history() {
        return this.history;
    }

    /**
     * Print <i>length</i> last commands (only names).
     */
    public void printLast() {
        ArrayList<AbstractCommand> l = history();
        for (AbstractCommand c : l) {
            System.out.println(c.toString());
        }
    }
}
