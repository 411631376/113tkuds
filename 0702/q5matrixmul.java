import java.util.Scanner;

public class q5matrixmul {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[][] A = new int[n][n], B = new int[n][n], C = new int[n][n];
        int ops = 0;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                A[i][j] = cin.nextInt();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                B[i][j] = cin.nextInt();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                    ops += 2;
                }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(C[i][j]);
                if (j < n - 1) System.out.print(" ");
            }
            System.out.println();
        }

        System.err.println(ops);
    }
}