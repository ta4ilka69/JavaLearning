import Collection.CSVReader;
import Collection.MyCollection;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyCollection c = new MyCollection();
        CSVReader reader = new CSVReader(args[0]);
        try {
            reader.read(c);
        } catch (Exception e) {
            if (e instanceof FileNotFoundException) {
                System.out.println("Нет файла");
            }
        }
        String nextLine = scanner.nextLine();
        c.clear();
        while (!nextLine.equals("exit")) {
            if (nextLine.equals("print")) {
                c.print();
            } else if (nextLine.startsWith("delete")) {
                int id = Integer.parseInt(nextLine.split(" ")[1]);
                c.delete(id);
            } else if (nextLine.startsWith("add")) {
                c.add(nextLine.split(" ")[1]);
            } else {
                System.out.println("Неопознанная команда");
            }
            nextLine = scanner.nextLine();
        }
    }
}
