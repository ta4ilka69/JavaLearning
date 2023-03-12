package Collection;

import Collection.Commands.AbstractCommand;

import java.util.ArrayList;

public class HistoryManager {
    private ArrayList<AbstractCommand> history;
    private int lenght;

    public HistoryManager(int lenght){
        this.history = new ArrayList<>();
        this.lenght = lenght;
    }
    public void update(AbstractCommand c){
        if(this.history.size()<this.lenght){
            this.history.add(c);
        }
        else{
            this.history.remove(0);
            this.history.add(c);
        }
    }
    public ArrayList<AbstractCommand> history(){
        return this.history;
    }
}
