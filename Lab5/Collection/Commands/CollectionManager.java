package Collection.Commands;

import Collection.MyCollection;

public class CollectionManager {
    private MyCollection collection;

    public CollectionManager(MyCollection collection) {
        this.collection = collection;
    }

    public MyCollection getCollection() {
        return collection;
    }
}
