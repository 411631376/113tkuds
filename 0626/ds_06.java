import java.util.Random;
public class ds_06 {
   public static void main(String[] args) {
       int[] ran=new int[10];
       Random rand=new Random();

       for(int i=0;i<ran.length;i++){
        ran[i]=rand.nextInt(100)+1;
         System.out.print(ran[i]+" ");
       }
      
       int max=ran[0];
       for(int i=1;i<ran.length;i++){
        if(ran[i]>max){
            max=ran[i];
             
        }
    }
    System.err.println(" ");
        System.out.println(max);
       
      
   }
}