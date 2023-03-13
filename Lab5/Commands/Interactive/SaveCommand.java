package Commands.Interactive;

import Commands.AbstractCommand;
import Collection.MyCollection;
import FileManager.CollectionWriter;

public class SaveCommand extends AbstractCommand {
    public SaveCommand(MyCollection collection){
        super(collection,null);
    }

    @Override
    public void execute() {
        CollectionWriter writer = new CollectionWriter(this.getCollection());
        writer.execute();
    }

    public static String info(){
        return "Saves collection into file";
    }
}
