import java.util.Scanner;

public class OJ15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] matrix = new int[N][N];

        int top = 0, bottom = N - 1;
        int left = 0, right = N - 1;
        int num = 1;

        while (num <= N * N) {
            for (int i = left; i <= right; i++) matrix[top][i] = num++;
            top++;
            for (int i = top; i <= bottom; i++) matrix[i][right] = num++;
            right--;
            for (int i = right; i >= left; i--) matrix[bottom][i] = num++;
            bottom--;
            for (int i = bottom; i >= top; i--) matrix[i][left] = num++;
            left++;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j]);
                if (j < N - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }
}