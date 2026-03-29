import java.util.Scanner;
public class Bmi2dArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();
        double[][] personData = new double[n][3];
        String[] weightStatus = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Person " + (i + 1));
            System.out.print("Enter weight (kg): ");
            personData[i][0] = sc.nextDouble();
            System.out.print("Enter height (m): ");
            personData[i][1] = sc.nextDouble();
            if (personData[i][0] <= 0 || personData[i][1] <= 0) {
                System.out.println("Invalid input! Re-enter.");
                i--;
                continue;
            }
            personData[i][2] = personData[i][0] /
                    (personData[i][1] * personData[i][1]);
            double bmi = personData[i][2];
            if (bmi < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi < 25) {
                weightStatus[i] = "Normal";
            } else if (bmi < 40) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }
        System.out.println("\nResults:");
        for (int i = 0; i < n; i++) {
            System.out.println("Person " + (i + 1) +
                    " -> Weight: " + personData[i][0] +
                    ", Height: " + personData[i][1] +
                    ", BMI: " + personData[i][2] +
                    ", Status: " + weightStatus[i]);
        }
        sc.close();
    }
}