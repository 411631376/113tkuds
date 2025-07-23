    import java.util.Scanner;

public class Gcd{

    // 遞迴版歐幾里得演算法
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入第一個正整數：");
        int a = scanner.nextInt();

        System.out.print("請輸入第二個正整數：");
        int b = scanner.nextInt();

        if (a <= 0 || b <= 0) {
            System.out.println("請輸入正整數！");
            return;
        }

        int result = gcd(a, b);
        System.out.println("最大公因數是：" + result);
    }
}
