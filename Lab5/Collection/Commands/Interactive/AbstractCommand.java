package Collection.Commands.Interactive;

import Collection.MyCollection;

public class AbstractCommand{
    private MyCollection collection;
    public AbstractCommand(MyCollection collection) {
        this.collection = collection;
    }
}
