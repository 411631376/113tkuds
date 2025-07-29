import java.util.*;

public class F04_TieredIncomeTax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        double[] taxes = new double[n];
        double totalTax = 0;

        for (int i = 0; i < n; i++) {
            int income = Integer.parseInt(sc.nextLine());
            double tax = calculateTax(income);
            taxes[i] = tax;
            totalTax += tax;
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("Tax: $%.0f\n", taxes[i]);
        }

        double avg = totalTax / n;
        System.out.printf("Average: $%.2f\n", avg);
    }


    public static double calculateTax(int income) {
        int[] brackets = {540_000, 1_210_000, 2_420_000, 4_530_000};
        double[] rates = {0.05, 0.12, 0.20, 0.30, 0.40};

        double tax = 0;
        int prev = 0;
        for (int i = 0; i < brackets.length; i++) {
            if (income <= brackets[i]) {
                tax += (income - prev) * rates[i];
                return tax;
            } else {
                tax += (brackets[i] - prev) * rates[i];
                prev = brackets[i];
            }
        }
        tax += (income - prev) * rates[rates.length - 1];
        return tax;
    }
}

/*
 * Time Complexity: O(n)
 * 說明：每筆收入只需逐一對照級距計算稅額，
 * 級距為固定長度常數（最多 5 段），處理 n 筆收入即為 O(n)。
 */
