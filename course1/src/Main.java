public class Main {
    public static void main(String[] args) {
        int N = 10, k = 3;
        int ans = Josephus.Josephus(N, k);
        System.out.println(ans);
        System.out.println(Josephus.Josephus3(N));
    }
}