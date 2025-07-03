import java.util.Scanner;

public class OJ12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] sum = new int[m];

        for (int i = 0; i < n * m; i++)
            sum[i % m] += sc.nextInt();

        for (int i = 0; i < m; i++)
            System.out.print(sum[i] + (i < m - 1 ? " " : ""));
    }
}