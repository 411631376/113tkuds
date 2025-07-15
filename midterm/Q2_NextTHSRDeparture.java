import java.util.*;

public class Q2_NextTHSRDeparture {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] minutes = new int[n];
        String[] times = new String[n];

        for (int i = 0; i < n; i++) {
            String time = sc.nextLine();
            times[i] = time;
            String[] parts = time.split(":");
            int hour = Integer.parseInt(parts[0]);
            int minute = Integer.parseInt(parts[1]);
            minutes[i] = hour * 60 + minute;
        }

        String query = sc.nextLine();
        String[] qParts = query.split(":");
        int qMin = Integer.parseInt(qParts[0]) * 60 + Integer.parseInt(qParts[1]);

        int idx = Arrays.binarySearch(minutes, qMin + 1);
        if (idx < 0) idx = -idx - 1;

        if (idx == n) {
            System.out.println("No train");
        } else {
            System.out.println(times[idx]);
        }
    }
}

/*
 * Time Complexity: O(log n)
 * 說明：因為班次時間已經排序好了，我們用 binary search 找下一班車，所以是對數時間。
 * 也就是查詢越多班次，效率還是很快，不用一筆一筆找。
 */