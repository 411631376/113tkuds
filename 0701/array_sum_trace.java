public class array_sum_trace {
    public static void main(String[] args) {

        int[] arr = {1, 3, 5};
        
        int total = 0;  
        
        for (int i = 0; i < arr.length; i++) {
            System.out.println("加總過程：total = " + total + " + " + arr[i] + " = " + (total + arr[i]));
            total = total + arr[i];  
        }

        System.out.println("總和為：" + total);
    }
}
        // 迴圈會從頭到尾把陣列裡的每個數字都跑一次
        // 所以不管陣列裡有幾個數字，都一定是每個都加一次
        // 總共跑 n 次（n 是陣列長度），所以時間複雜度是 O(n)