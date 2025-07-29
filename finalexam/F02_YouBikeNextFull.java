import java.util.*;

public class F02_YouBikeNextFull {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[] timeSlots = new int[n];


        for (int i = 0; i < n; i++) {
            String time = sc.nextLine();
            timeSlots[i] = toMinutes(time);
        }

 
        String queryTimeStr = sc.nextLine();
        int queryTime = toMinutes(queryTimeStr);

  
        int idx = Arrays.binarySearch(timeSlots, queryTime);
        if (idx < 0) idx = -idx - 1;

        if (idx < n) {
            System.out.println(toHHMM(timeSlots[idx]));
        } else {
            System.out.println("No bike");
        }
    }

    
        public static int toMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    public static String toHHMM(int mins) {
        int h = mins / 60;
        int m = mins % 60;
        return String.format("%02d:%02d", h, m);
    }
}

/*
 * Time Complexity: O(log n)
 * 說明：
 * 補車時間已排序，因此使用二分搜尋查找大於等於查詢時間的第一筆資料，
 * 二分搜尋的時間複雜度為 O(log n)；
 * 轉換與輸出操作皆為 O(1)，總體為 O(log n)。
 */