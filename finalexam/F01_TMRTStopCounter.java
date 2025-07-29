import java.util.*;

public class F01_TMRTStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); 
        List<String> stations = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            stations.add(sc.next());
        }

        String start = sc.next();
        String end = sc.next();

        int indexStart = stations.indexOf(start);
        int indexEnd = stations.indexOf(end);

        if (indexStart == -1 || indexEnd == -1) {
            System.out.println("Invalid");
        } else {
            int stopCount = Math.abs(indexStart - indexEnd) + 1;
            System.out.println(stopCount);
        }
    }
}

/*
 * Time Complexity: O(n)
 * 說明：
 * 輸入站碼時需 O(n)，並透過 indexOf 搜尋起訖站碼各一次，每次皆為 O(n)。
 * 整體最大為 O(n) + 2*O(n) = O(n)，符合線性時間複雜度。
 */