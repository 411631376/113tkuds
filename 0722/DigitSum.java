public class digitSum {

    public static int digitSum(int n) {
        if (n < 10) {
            return n;
        }
        return n % 10 + digitSum(n / 10);
    }

    public static void main(String[] args) {
        System.out.println(digitSum(1234)); // 10
        System.out.println(digitSum(987));  // 24
    }
}
