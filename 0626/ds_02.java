import java.util.Scanner;

public class ds_02 {
    public static void main(String[] args) {
        
        Scanner cin =new Scanner(System.in);
        System.out.println("請輸入半徑 ");
        double a,area;
        a=cin.nextDouble();
        area=Math.PI*a*a;
        System.err.println("area"+area);
    }
}