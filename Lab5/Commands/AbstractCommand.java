package Commands;

import Collection.MyCollection;
import ElementClasses.HumanBeing;

public class AbstractCommand implements Executable {
    private MyCollection collection;
    private HumanBeing h;
    public AbstractCommand(MyCollection collection, HumanBeing h) {
        this.collection = collection;
        this.h = h;
    }
    public void execute(){}
    public static String info(){
        return "Abstract Command";
    };
    public HumanBeing getElement(){
        return this.h;
    }

    public MyCollection getCollection() {
        return collection;
    }
    public String toString(){
        return "Abstract command";
    }
}
