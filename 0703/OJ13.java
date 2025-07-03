import java.util.Scanner;

public class OJ13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++)
                System.out.print(j + (i == 1 && j == i ? "" : " "));
            for (int j = i - 1; j >= 1; j--)
                System.out.print(j + (j == 1 ? "" : " "));
            System.out.println();
        }
    }
}