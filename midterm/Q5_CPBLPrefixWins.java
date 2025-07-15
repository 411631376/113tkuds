import java.util.*;

public class Q5_CPBLPrefixWins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[] results = new int[n];
        String[] tokens = sc.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            results[i] = Integer.parseInt(tokens[i]);
        }

        int k = Integer.parseInt(sc.nextLine());

        int[] prefix = new int[k];
        prefix[0] = results[0];

        for (int i = 1; i < k; i++) {
            prefix[i] = prefix[i - 1] + results[i];
        }

        System.out.print("PrefixSum:");
        for (int i = 0; i < k; i++) {
            System.out.print(" " + prefix[i]);
        }
        System.out.println();
    }
}

/*
 * Time Complexity: O(n)
 * 說明：直接建立 prefix sum 陣列，一次走訪就能完成累積勝場的計算，查詢輸出也只走 k 次。
 */
