import java.util.Random;
public class StudentScoreCard {
    public static void main(String[] args) {
        int numberOfStudents = 5;
        int[][] pcmScores = generateRandomScores(numberOfStudents);
        double[][] stats = calculateStats(pcmScores);
        String[][] grades = calculateGrades(stats);
        displayScorecard(pcmScores, stats, grades);
    }
    public static int[][] generateRandomScores(int numStudents) {
        Random random = new Random();
        int[][] scores = new int[numStudents][3];
        for (int i = 0; i < numStudents; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = random.nextInt(90) + 10;
            }
        }
        return scores;
    }
    public static double[][] calculateStats(int[][] scores) {
        double[][] stats = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            double total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100.0;
            stats[i][0] = total;
            stats[i][1] = Math.round(average * 100.0) / 100.0;
            stats[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return stats;
    }
    public static String[][] calculateGrades(double[][] stats) {
        String[][] grades = new String[stats.length][1];
        for (int i = 0; i < stats.length; i++) {
            double p = stats[i][2];
            if (p >= 80) grades[i][0] = "A";
            else if (p >= 70) grades[i][0] = "B";
            else if (p >= 60) grades[i][0] = "C";
            else if (p >= 50) grades[i][0] = "D";
            else if (p >= 40) grades[i][0] = "E";
            else grades[i][0] = "R";
        }
        return grades;
    }
    public static void displayScorecard(int[][] scores, double[][] stats, String[][] grades) {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("%-10s %-5s %-5s %-5s %-8s %-8s %-12s %-5s\n", 
                          "Student", "Phy", "Che", "Mat", "Total", "Avg", "Percentage", "Grade");
        System.out.println("-----------------------------------------------------------------------------");
        
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("Student %-2d %-5d %-5d %-5d %-8.0f %-8.2f %-12.2f %-5s\n",
                              (i + 1), scores[i][0], scores[i][1], scores[i][2], 
                              stats[i][0], stats[i][1], stats[i][2], grades[i][0]);
        }
        System.out.println("-----------------------------------------------------------------------------");
    }
}
