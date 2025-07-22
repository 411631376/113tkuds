import java.util.Scanner;

public class FactorialExampleinput {

    public static long factorial(int n) {
        long result = 1;
        for (int i = n; i >= 1; i--) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入一個非負整數: ");
        int num = scanner.nextInt();

        if (num < 0) {
            System.out.println("錯誤：請輸入非負整數！");
            return;
        }

        System.out.print(num + "! = ");
        for (int i = num; i >= 1; i--) {
            System.out.print(i);
            if (i != 1) {
                System.out.print(" * ");
            }
        }

        System.out.println(" = " + factorial(num));
    }
}