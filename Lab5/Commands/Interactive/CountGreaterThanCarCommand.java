package Commands.Interactive;

import Collection.MyCollection;
import Commands.AbstractCommand;
import ElementClasses.Car;

/**
 * Command for counting elements that have greater Car.
 * @see Car
 * @see MyCollection
 * @see AbstractCommand
 */
public class CountGreaterThanCarCommand extends AbstractCommand {
    /**
     * Car for compare.
     */
    private Car car;

    /**
     * Constructor of command, invoke super() with null element.
     * @param collection sets collection.
     * @param car sets car.
     */
    public CountGreaterThanCarCommand(MyCollection collection, Car car) {
        super(collection, null);
        this.car = car;
    }
    /**
     * @return name of command.
     */
    @Override
    public String toString() {
        return "count_greater_than_car";
    }
    /**
     * @return information for "help" command.
     */
    public static String info() {
        return "count_greater_than_car car : вывести количество элементов, значение поля car которых больше заданного";
    }

    /**
     * Count elements what`s cars are better than given.
     */
    @Override
    public void execute() {
        getCollection().count_greater_than_car(this.car);
    }
}
