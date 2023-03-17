package Commands;

import ElementClasses.Car;

import java.io.InputStream;
import java.util.Scanner;

public class CarReader {
    private Scanner scanner;
    public CarReader(InputStream in){
        scanner = new Scanner(in);
    }

    public Car getCar(){
        System.out.println("Enter name of the car:");
        String name = scanner.nextLine();
        System.out.println("Enter cool:");
        String line = scanner.nextLine();
        while(!line.equals("false")&&!line.equals("true")){
            line = scanner.nextLine();
        }
        Car car = new Car(name);
        car.setCool(Boolean.parseBoolean(line));
        return car;
    }
}
