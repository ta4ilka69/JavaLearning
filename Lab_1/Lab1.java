import java.lang.Math;
import java.util.Random;

public class Lab1 {
    public static void main(String[] args) {
        // Task 1
        Short[] a = new Short[18];
        for (int i = 0; i < a.length; i++) {
            a[i] = (short) (i + 3);
        }
        // Task 2
        Double[] x = new Double[16];
        for (int i = 0; i < x.length; i++) {
            x[i] = rand();
            System.out.println(x[i]);
        }
    }

    // for Task 2
    public static Double rand() {
        Random rnd = new Random();
        double x = rnd.nextDouble() * 11 - 9;
        return (x);
    }
}
