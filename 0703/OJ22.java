import java.util.Scanner;

public class OJ22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double r = sc.nextDouble(); // 輸入半徑
        double area = 3.14 * r * r;
        System.out.printf("%.2f\n", area); // 輸出到小數點後兩位
    }
}
