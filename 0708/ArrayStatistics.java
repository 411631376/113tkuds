class ArrayStatistics {
    public static void main(String[] args) {
        int[] data = {5, 12, 8, 15, 7, 23, 18, 9, 14, 6};

        
        int sum = 0;
        int max = data[0];
        int min = data[0];
        int maxIndex = 0;
        int minIndex = 0;
        int evenCount = 0;
        int oddCount = 0;


        for (int i = 0; i < data.length; i++) {
            int value = data[i];
            sum += value;

            if (value > max) {
                max = value;
                maxIndex = i;
            }
            if (value < min) {
                min = value;
                minIndex = i;
            }

            if (value % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        double average = (double) sum / data.length;
        int aboveAverageCount = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] > average) {
                aboveAverageCount++;
            }
        }

        System.out.println("=== 陣列統計報表 ===");
        System.out.printf("總和: %d\n", sum);
        System.out.printf("平均值: %.2f\n", average);
        System.out.printf("最大值: %d（索引 %d）\n", max, maxIndex);
        System.out.printf("最小值: %d（索引 %d）\n", min, minIndex);
        System.out.printf("大於平均的數量: %d\n", aboveAverageCount);
        System.out.printf("偶數個數: %d\n", evenCount);
        System.out.printf("奇數個數: %d\n", oddCount);
    }
}