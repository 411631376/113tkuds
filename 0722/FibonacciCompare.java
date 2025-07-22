public class FibonacciCompare{

    public static int fibonacciSlow(int n) {
        if (n <= 1) return n;
        return fibonacciSlow(n - 1) + fibonacciSlow(n - 2);
    }

    public static int fibonacciFast(int n, int[] memo) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];
        memo[n] = fibonacciFast(n - 1, memo) + fibonacciFast(n - 2, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 30;

        long start1 = System.nanoTime();
        int slowResult = fibonacciSlow(n);
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        int[] memo = new int[n + 1];
        int fastResult = fibonacciFast(n, memo);
        long end2 = System.nanoTime();

        System.out.println("fibonacciSlow(" + n + ") = " + slowResult + ", 耗時: " + (end1 - start1) / 1_000_000.0 + " ms");
        System.out.println("fibonacciFast(" + n + ") = " + fastResult + ", 耗時: " + (end2 - start2) / 1_000_000.0 + " ms");
    }
}
