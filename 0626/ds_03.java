import java.util.Scanner;

public class ds_03 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        System.out.println("請輸入您的姓名: ");
        String name = cin.nextLine();

        System.out.println("請輸入您的年齡: ");
        int age = cin.nextInt();

        cin.nextLine();

        System.out.println("請輸入您的城市: ");
        String city = cin.nextLine();

        System.out.println("\n您輸入的個人資訊如下:");
        System.out.println("姓名: " + name);
        System.out.println("年齡: " + age);
        System.out.println("城市: " + city);

        cin.close();
    }
}