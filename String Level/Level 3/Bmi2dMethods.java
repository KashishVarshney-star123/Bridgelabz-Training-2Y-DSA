import java.util.Scanner;
public class Bmi2dMethods {
    public static double[][] calculateBMI(double[][] data) {
        int n = data.length;
        double[][] result = new double[n][3];
        for (int i = 0; i < n; i++) {
            double weight = data[i][0];
            double heightCm = data[i][1];
            double heightM = heightCm / 100.0;
            double bmi = weight / (heightM * heightM);
            result[i][0] = heightCm;
            result[i][1] = weight;
            result[i][2] = Math.round(bmi * 100.0) / 100.0;
        }
        return result;
    }
    public static String getStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25) return "Normal";
        else if (bmi < 40) return "Overweight";
        else return "Obese";
    }
    public static void display(double[][] result) {
        System.out.println("\nHeight(cm)\tWeight\tBMI\tStatus");
        for (int i = 0; i < result.length; i++) {
            String status = getStatus(result[i][2]);
            System.out.println(result[i][0] + "\t\t" +
                    result[i][1] + "\t" +
                    result[i][2] + "\t" +
                    status);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[10][2];
        for (int i = 0; i < 10; i++) {
            System.out.println("Person " + (i + 1));
            System.out.print("Enter weight (kg): ");
            data[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm): ");
            data[i][1] = sc.nextDouble();
        }
        double[][] result = calculateBMI(data);
        display(result);
        sc.close();
    }
}