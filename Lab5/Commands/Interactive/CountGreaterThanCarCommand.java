package Commands.Interactive;

import Collection.MyCollection;
import Commands.AbstractCommand;
import ElementClasses.Car;

public class CountGreaterThanCarCommand extends AbstractCommand {
    private Car car;
    public CountGreaterThanCarCommand(MyCollection collection, Car car){
        super(collection,null);
        this.car = car;
    }

    @Override
    public String toString() {
        return "count_greater_than_car";
    }

    public static String info(){
        return "count_greater_than_car car : вывести количество элементов, значение поля car которых больше заданного";
    }

    @Override
    public void execute() {
        getCollection().count_greater_than_car(this.car);
    }
}
