import Collection.Commands.CommandManager;
import Collection.MyCollection;

public class Lab5 {
    public static void main(String[] args) {
        MyCollection c = new MyCollection();
        CommandManager in = new CommandManager(System.in,c);
        in.start();
    }
}
