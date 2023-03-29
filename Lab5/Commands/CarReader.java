package Commands;

import ElementClasses.Car;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Class for reading Car.
 * @see ElementClasses.Car
 */
public class CarReader {
    /**
     * Scanner for reading fields.
     */
    private Scanner scanner;

    /**
     * Constructor for class.
     * @param in is input stream, scanner field is made on it.
     */

    public CarReader(InputStream in) {
        scanner = new Scanner(in);
    }

    /**
     * Reads fields with scanner.
     * @return Car object
     */
    public Car getCar() {
        System.out.println("Enter name of the car:");
        String name = scanner.nextLine();
        System.out.println("Enter cool:");
        String line = scanner.nextLine();
        while (!line.equals("false") && !line.equals("true")) {
            line = scanner.nextLine();
        }
        Car car = new Car(name);
        car.setCool(Boolean.parseBoolean(line));
        return car;
    }
}
