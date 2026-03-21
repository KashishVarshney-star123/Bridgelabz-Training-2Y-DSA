import java.util.Scanner;

public class BMI{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons in the team: ");
        int n = sc.nextInt();
        double[] weights = new double[n];
        double[] heights = new double[n];
        double[] bmis = new double[n];
        String[] status = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nPerson " + (i + 1));
            System.out.print("Weight (kg): ");
            weights[i] = sc.nextDouble();
            System.out.print("Height (m): ");
            heights[i] = sc.nextDouble();

            bmis[i] = weights[i] / (heights[i] * heights[i]);
            if (bmis[i] <= 18.4) status[i] = "Underweight";
            else if (bmis[i] <= 24.9) status[i] = "Normal";
            else if (bmis[i] <= 39.9) status[i] = "Overweight";
            else status[i] = "Obese";
        }
        System.out.println("\n--- Team BMI Report ---");
        System.out.println("Height\tWeight\tBMI\tStatus");
        for (int i = 0; i < n; i++) {
            System.out.printf("%.2fm\t%.1fkg\t%.1f\t%s\n", 
                               heights[i], weights[i], bmis[i], status[i]);
        }
    }
}