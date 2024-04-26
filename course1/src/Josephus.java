import java.lang.Math;

public class Josephus {
    public static int Josephus(int N, int k) {
        int i = 1, ans = 0;
        while (i <= N) {

            ans = (ans + k) % i;
            i++;
        }
        return ans + 1;
    }


    public static int Josephus3(int n) {
        if (n == 1) return 1;
        int k = Josephus3(n / 3);
        if(n%3==0){
            return 3*k;
        }
        if(n%3==1){
            return 3*k-2;
        }
        return 3*k-1;
    }
}
