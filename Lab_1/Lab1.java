import java.lang.Math;
import java.util.Random;

public class Lab1 {
    public static void main(String[] args) {
        // Task 1
        short[] f = new short[18];
        for (int i = 0; i < f.length; i++) {
            f[i] = (short) (i + 3);
        }
        // Task 2
        double[] x = new double[16];
        for (int i = 0; i < x.length; i++) {
            x[i] = rand();
        }
        // Task 3
        Double[][] a = new Double[18][16];
        int[] specInd = { 3, 4, 7, 8, 9, 10, 12, 17, 19 };
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (f[i] == 16) {
                    a[i][j] = Math.pow(Math.log(Math.pow(Math.tan(x[j]), 2)),
                            (Math.pow(2 * Math.asin((x[j] - 3.5) / 11), Math.pow((1 - x[j]) / 3, 2)) - 1) / 3);
                } else {
                    if (contain(specInd, f[i])) {
                        a[i][j] = Math
                                .cos(Math.pow(Math.cbrt(x[j]) * (Math.pow(Math.E, x[j]) + 0.5), Math.tan(x[j])));
                    } else {
                        a[i][j] = Math.cbrt(
                                Math.log(Math.pow(Math.sin(Math.pow((2 + Math.pow(x[j], 1 - x[j])) / 3, 2)), 2)));
                    }
                }
                System.out.print(String.format("%7.4f", a[i][j]) + "   ");
            }
            System.out.print("\n");
        }

    }

    // generate random float (-9,2)
    public static Double rand() {
        Random rnd = new Random();
        double x = Math.sin(rnd.nextDouble()*Math.PI/2) * 11 - 9;
        return (x);
    }

    // check if array contains element
    public static Boolean contain(int[] a, int el) {
        Boolean f = false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == el) {
                f = true;
                break;
            }
        }
        return (f);
    }
}
