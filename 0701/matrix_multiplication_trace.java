public class matrix_multiplication_trace {
    public static void main(String[] args) {
        
        int[][] a = {
            {1, 2},
            {3, 4}
        };

        int[][] b = {
            {5, 6},
            {7, 8}
        };

        int[][] c = new int[2][2];  

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = 0;
                // 印出乘法加總的過程
                System.out.print("計算位置 c[" + i + "][" + j + "]：");
                System.out.print(a[i][0] + "*" + b[0][j] + " + " + a[i][1] + "*" + b[1][j]);
                int part1 = a[i][0] * b[0][j];
                int part2 = a[i][1] * b[1][j];
                c[i][j] = part1 + part2;
                System.out.println(" = " + part1 + " + " + part2 + " = " + c[i][j]);
            }
        }

        // 印出結果矩陣
        System.out.println("結果矩陣：");
        for (int i = 0; i < 2; i++) {
            System.out.println(c[i][0] + " " + c[i][1]);
        }

        // 雖然我們這裡是 2x2 矩陣，但如果變成 n x n 的話，
        // 三層迴圈就會跑 n * n * n 次 → 所以時間複雜度是 O(n³)
    }
}