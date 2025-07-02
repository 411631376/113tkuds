import java.util.Scanner;

public class q4paircount {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] arr = new int[n];

 
        for (int i = 0; i < n; i++) {
            arr[i] = cin.nextInt();
        }

        int count = 0;
        int ops = 0;

      
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                count++;
                ops++;
            }
        }

        System.out.println(count);
        System.err.println(ops);
    }
}