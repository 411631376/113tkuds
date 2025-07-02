import java.util.Scanner;
public class q1arraysum {
public static void main(String[] args) {
    Scanner cin=new Scanner(System.in);
    int n=cin.nextInt();
    int sum=0;
    for(int i=0;i<n;i++){
        int num=cin.nextInt();
        sum+=num;
    }
    System.out.println(sum);
    System.err.println(n);
} 

}
