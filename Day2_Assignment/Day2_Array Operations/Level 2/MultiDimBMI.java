import java.util.Scanner;

public class MultiDimBMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();

        // b. Create 2D array: [row][column] -> [person][weight, height, bmi]
        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        for (int i = 0; i < number; i++) {
            double w, h;
            do {
                System.out.print("Enter weight (kg) and height (m) for person " + (i + 1) + ": ");
                w = sc.nextDouble();
                h = sc.nextDouble();
                if (w <= 0 || h <= 0) System.out.println("Please enter positive values!");
            } while (w <= 0 || h <= 0);
            personData[i][0] = w;
            personData[i][1] = h;
            personData[i][2] = w / (h * h);
            if (personData[i][2] <= 18.4) weightStatus[i] = "Underweight";
            else if (personData[i][2] <= 24.9) weightStatus[i] = "Normal";
            else if (personData[i][2] <= 39.9) weightStatus[i] = "Overweight";
            else weightStatus[i] = "Obese";
        }
        System.out.println("\nWeight\tHeight\tBMI\tStatus");
        for (int i = 0; i < number; i++) {
            System.out.printf("%.1f\t%.2f\t%.1f\t%s\n", 
                personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }
    }
}