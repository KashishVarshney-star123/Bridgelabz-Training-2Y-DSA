public class SelectionSort {
    public static void sortScores(int[] scores) {
        int n = scores.length;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = scores[minIdx];
            scores[minIdx] = scores[i];
            scores[i] = temp;
        }
    }
    public static void main(String[] args) {
        int[] examScores = {88, 72, 95, 64, 50};
        sortScores(examScores);
        System.out.println("Selection Sorted Scores: " + java.util.Arrays.toString(examScores));
    }
}