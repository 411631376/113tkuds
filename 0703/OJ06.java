import java.util.Scanner;

public class OJ06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int intNum = scanner.nextInt();
        double doubleNum = scanner.nextDouble();
        double sum = intNum + doubleNum;
        System.out.printf("%.2f\n", sum);
    }
}