package Commands.Interactive;

import Commands.AbstractCommand;
import Collection.MyCollection;
import FileManager.CollectionWriter;

public class SaveCommand extends AbstractCommand {
    private String path;
    public SaveCommand(MyCollection collection){
        super(collection,null);
        this.path = collection.getPathToSave();
    }

    @Override
    public void execute() {
        getCollection().setPathToSave(path);
        CollectionWriter writer = new CollectionWriter(this.getCollection());
        writer.execute();
    }

    public static String info(){
        return "save : сохранить коллекцию в файл";
    }

    @Override
    public String toString() {
        return "save";
    }

    public void setPath(String path){
        this.path = path;
    }
}
