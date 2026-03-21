import java.util.Scanner;
public class BmiTracker {
    public static String[] getBmiAndStatus(double weight, double heightCm) {
        double heightM = heightCm / 100.0;
        double bmi = weight / (heightM * heightM);
        String status;
        if (bmi <= 18.4) status = "Underweight";
        else if (bmi <= 24.9) status = "Normal";
        else if (bmi <= 39.9) status = "Overweight";
        else status = "Obese";
        return new String[]{String.format("%.2f", bmi), status};
    }
    public static String[][] processData(double[][] inputData) {
        String[][] report = new String[10][4];
        for (int i = 0; i < 10; i++) {
            double weight = inputData[i][0];
            double height = inputData[i][1];
            String[] result = getBmiAndStatus(weight, height);
            report[i][0] = String.valueOf(weight);
            report[i][1] = String.valueOf(height);
            report[i][2] = result[0];
            report[i][3] = result[1];
        }
        return report;
    }
    public static void displayReport(String[][] report) {
        System.out.println("\nWeight\tHeight\tBMI\tStatus");
        System.out.println("------------------------------------");
        for (String[] row : report) {
            System.out.println(row[0] + "\t" + row[1] + "\t" + row[2] + "\t" + row[3]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[10][2];
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) and height (cm) for person " + (i + 1) + ": ");
            data[i][0] = sc.nextDouble();
            data[i][1] = sc.nextDouble();
        }
        String[][] finalReport = processData(data);
        displayReport(finalReport);
    }
}