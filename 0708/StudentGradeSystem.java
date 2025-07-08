public class StudentGradeSystem {
    public static void main(String[] args) {
        int[] scores = {85, 92, 78, 96, 87, 73, 89, 94, 81, 88};
        char[] grades = new char[scores.length];

        int sum = 0;
        int maxScore = scores[0], minScore = scores[0];
        int maxIndex = 0, minIndex = 0;

        int countA = 0, countB = 0, countC = 0, countD = 0;

        // 評分與統計等級人數
        for (int i = 0; i < scores.length; i++) {
            int score = scores[i];
            sum += score;

            if (score >= 90) {
                grades[i] = 'A';
                countA++;
            } else if (score >= 80) {
                grades[i] = 'B';
                countB++;
            } else if (score >= 70) {
                grades[i] = 'C';
                countC++;
            } else {
                grades[i] = 'D';
                countD++;
            }

            if (score > maxScore) {
                maxScore = score;
                maxIndex = i;
            }
            if (score < minScore) {
                minScore = score;
                minIndex = i;
            }
        }

        double average = (double) sum / scores.length;

        // 計算高於平均的學生數
        int aboveAvgCount = 0;
        for (int score : scores) {
            if (score > average) {
                aboveAvgCount++;
            }
        }

        // 輸出詳細列表
        System.out.println("=== 成績報表 ===");
        System.out.printf("%-6s %-6s %-4s\n", "編號", "分數", "等級");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-6d %-6d %-4c\n", i, scores[i], grades[i]);
        }

        // 統計摘要
        System.out.println("\n--- 統計摘要 ---");
        System.out.printf("最高分：%d（編號 %d）\n", maxScore, maxIndex);
        System.out.printf("最低分：%d（編號 %d）\n", minScore, minIndex);
        System.out.printf("平均分數：%.2f\n", average);
        System.out.printf("高於平均人數：%d（%.1f%%）\n",
                aboveAvgCount, 100.0 * aboveAvgCount / scores.length);
        System.out.printf("等級統計：A=%d, B=%d, C=%d, D=%d\n",
                countA, countB, countC, countD);
    }
}
