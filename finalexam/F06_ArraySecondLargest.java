import java.util.*;

public class F06_ArraySecondLargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Pair result = findMaxSecond(nums, 0, n - 1);
        System.out.println("SecondMax: " + result.second);
    }

    static class Pair {
        int max;
        int second;

        Pair(int max, int second) {
            this.max = max;
            this.second = second;
        }
    }

    static Pair findMaxSecond(int[] arr, int left, int right) {
        if (left == right) {

            return new Pair(arr[left], Integer.MIN_VALUE);
        }

        int mid = (left + right) / 2;
        Pair leftPair = findMaxSecond(arr, left, mid);
        Pair rightPair = findMaxSecond(arr, mid + 1, right);

        int max, second;
        if (leftPair.max > rightPair.max) {
            max = leftPair.max;
            second = Math.max(leftPair.second, rightPair.max);
        } else {
            max = rightPair.max;
            second = Math.max(rightPair.second, leftPair.max);
        }

        return new Pair(max, second);
    }
}

/*
 * Time Complexity: O(n)
 * 說明：使用遞迴進行分治法，將陣列分成左右兩邊各自找最大與次大，
 * 合併時進行常數比較運算，因此每個元素只會被處理一次，
 * 整體時間複雜度為 O(n)。
 */
