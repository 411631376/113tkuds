import java.util.*;

public class Q4_TieredElectricBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int[] kwhList = new int[n];
        for (int i = 0; i < n; i++) {
            kwhList[i] = Integer.parseInt(sc.nextLine());
        }

        int total = 0;

        for (int i = 0; i < n; i++) {
            int kwh = kwhList[i];
            int bill = (int)Math.round(calc(kwh));
            total += bill;
            System.out.println("Bill: $" + bill);
        }

        int average = (int)Math.round((double) total / n);
        System.out.println("Total: $" + total);
        System.out.println("Average: $" + average);
    }

    // 計算分段累進費率
    public static double calc(int kwh) {
        double sum = 0;
        int[][] section = {
            {0, 120, 168},       // 1.68 * 100 = 168
            {121, 330, 245},
            {331, 500, 370},
            {501, 700, 504},
            {701, 1000, 624},
            {1001, Integer.MAX_VALUE, 846}
        };

        for (int[] s : section) {
            int from = s[0];
            int to = s[1];
            double price = s[2] / 100.0;
            if (kwh >= from) {
                int usage = Math.min(kwh, to) - from + 1;
                sum += usage * price;
                if (kwh <= to) break;
            }
        }

        return sum;
    }
}

/*
 * Time Complexity: O(n)
 * 說明：我們只走訪每個用電數各一次，每次最多經過六段計算電費，加總與平均也都是線性時間。
 * 所以整體處理速度很快，適合 n 到 1000。
 */
