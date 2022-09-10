public class Hello6 {
    public static void main(String[] args) {
        int i = 0;
        switch (args.length) {
            case 0:
                System.out.println("Привет всем!");
                break;
            default:
                while (i < args.length) {
                    System.out.println("Привет, " + args[i] + "!");
                    i++;
                }
        }
    }
}
