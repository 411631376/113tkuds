public class bigO_c {
    public static void main(String[] args) {
        int x = 0;
        int n = 5;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                x = x + 1;
            }
        }
        System.out.println("x = " + x);
    }
}