import java.util.*;

public class Q3_NightMarketRanking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        double[] scores = new double[n];

        for (int i = 0; i < n; i++) {
            scores[i] = Double.parseDouble(sc.nextLine());
        }
）
        for (int i = 0; i < Math.min(5, n); i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] > scores[maxIdx]) {
                    maxIdx = j;
                }
            }
            // swap
            double tmp = scores[i];
            scores[i] = scores[maxIdx];
            scores[maxIdx] = tmp;
        }

        // 輸出前五名
        for (int i = 0; i < Math.min(5, n); i++) {
            System.out.printf("%.1f\n", scores[i]);
        }
    }
}

/*
 * Time Complexity: O(n^2)
 * 說明：我用選擇排序，每次都從剩下的裡面找最大值來排，所以有兩層迴圈。
 * 雖然不是最快的方法，但題目 n 最多才 1000，這樣也跑得動。
 */
