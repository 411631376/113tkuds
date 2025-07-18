public class GradeProcessor {
    public static void main(String[] args) {
        int[] scores = {78, 85, 92, 67, 88, 95, 73, 90};

        int sum = 0;
        for (int score : scores) {
            sum += score;
        }

        double average = (double) sum / scores.length;
        System.out.printf("總分：%d\n", sum);
        System.out.printf("平均分數：%.2f\n", average);

        int max = scores[0], min = scores[0];
        int maxIndex = 0, minIndex = 0;

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
                maxIndex = i;
            }
            if (scores[i] < min) {
                min = scores[i];
                minIndex = i;
            }
        }

        System.out.printf("最高分：%d（索引 %d）\n", max, maxIndex);
        System.out.printf("最低分：%d（索引 %d）\n", min, minIndex);

        int countAboveAvg = 0;
        for (int score : scores) {
            if (score > average) {
                countAboveAvg++;
            }
        }
        System.out.printf("高於平均分的人數：%d 人\n", countAboveAvg);

        System.out.println("\n學生成績列表：");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("學生編號 %d：%d\n", i, scores[i]);
        }
    }
}