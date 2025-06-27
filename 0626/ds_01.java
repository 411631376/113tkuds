
import java.util.Scanner;

public class ds_01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("輸入第一個整數：");
        int number1 = input.nextInt();

        System.out.print("輸入第二個整數：");
        int number2 = input.nextInt();

        int sum = number1 + number2;

        System.out.println("兩個數字總和是: " + sum);
    }
}