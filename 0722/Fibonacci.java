public class Fibonacci {

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(0));  // 0
        System.out.println(fibonacci(1));  // 1
        System.out.println(fibonacci(5));  // 5
        System.out.println(fibonacci(10)); // 55
    }
}
