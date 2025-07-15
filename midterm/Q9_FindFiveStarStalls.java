import java.util.*;

public class Q9_FindFiveStarStalls {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int score = sc.nextInt();
            if (score == 5) {
                result.add(i);
            }
        }

        if (result.size() == 0) {
            System.out.println("None");
        } else {
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i));
                if (i != result.size() - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }
}
