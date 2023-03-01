package Collection;

public class CollectionManager {
    private MyCollection collection;

    public CollectionManager(MyCollection collection) {
        this.collection = collection;
    }

    public MyCollection getCollection() {
        return collection;
    }
    public void getCommand(String[] commandLine){
        String command = commandLine[0];
        switch (command) {
            case "add":

        }
    }
}
