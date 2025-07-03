import java.util.Scanner;

public class OJ20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 2; i <= N; i++) {
            boolean isPrime = true;
            
            // 試除法：從 2 試到 i-1（或 i 的平方根也可）
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break; // 一旦找到因數就不是質數，馬上 break
                }
            }

            if (isPrime) {
                System.out.print(i + " ");
            }
        }
    }
}