import java.util.Scanner;

public class OJ11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] colSum = new int[M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                colSum[j] += scanner.nextInt();
            }
        }

        for (int j = 0; j < M; j++) {
            System.out.print(colSum[j]);
            if (j < M - 1) {
                System.out.print(" ");
            }
        }
    }
}