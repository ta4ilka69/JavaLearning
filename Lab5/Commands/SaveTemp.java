package Commands;

import Collection.MyCollection;
import Commands.Interactive.SaveCommand;

public class SaveTemp extends SaveCommand {
    public SaveTemp(MyCollection collection){
        super(collection);
        this.setPath("tmp/temp.csv");
    }
}
