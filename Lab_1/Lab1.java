import java.lang.Math;
import java.util.Random;

public class Lab1 {
    public static void main(String[] args) {
        // Task 1
        Short[] а = new Short[18];
        for (int i = 0; i < а.length; i++) {
            а[i] = (short) (i + 3);
        }
        // Task 2
        Double[] x = new Double[16];
        for (int i = 0; i < x.length; i++) {
            x[i] = rand();
        }
        // Task 3
        Double[][] a = new Double[18][16];
        int[] specInd = { 3, 4, 7, 8, 9, 10, 12, 17, 19 };
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (а[i] == 16) {
                    a[i][j] = Math.pow(Math.log(Math.pow(Math.tan(x[j]), 2)),
                            (Math.pow(2 * Math.asin((x[j] - 3.5) / 11), Math.pow((1 - x[j]) / 3, 2)) - 1) / 3);
                } else {
                    if (contain(specInd, а[i])) {
                        a[i][j] = Math
                                .cos(Math.pow(Math.pow(x[j], 1 / 3) * (Math.pow(Math.E, x[j]) + 0.5), Math.tan(x[j])));
                    }
                    else{
                        a[i][j] = Math.pow(Math.log(Math.pow(Math.sin(Math.pow((2+Math.pow(x[j],1-x[j]))/3,2)), 2)),1/3);
                    }
                }
                System.out.printf("%.4f", a[i][j]);
            }
        }

    }

    // for Task 2
    public static Double rand() {
        Random rnd = new Random();
        double x = rnd.nextDouble() * 11 - 9;
        return (x);
    }

    // for Task 3
    public static Boolean contain(int[] a, int el) {
        Boolean f = false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == el) {
                f = true;
            }
        }
        return (f);
    }
}
