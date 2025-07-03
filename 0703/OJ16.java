import java.util.Scanner;

public class OJ16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 行數
        int M = sc.nextInt(); // 列數

        int[][] matrix = new int[N][M];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                matrix[i][j] = sc.nextInt();

        for (int j = 0; j < M; j++) {
            for (int i = 0; i < N; i++) {
                System.out.print(matrix[i][j]);
                if (i < N - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }
}