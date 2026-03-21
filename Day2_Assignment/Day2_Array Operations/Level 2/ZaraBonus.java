import java.util.Scanner;

public class ZaraBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] salaries = new double[10];
        double[] serviceYears = new double[10];
        double[] newSalaries = new double[10];
        double[] bonuses = new double[10];
        double totalOldSalary = 0, totalNewSalary = 0, totalBonus = 0;
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter salary and years of service for employee " + (i + 1) + ": ");
            double sal = sc.nextDouble();
            double yrs = sc.nextDouble();
            if (sal <= 0 || yrs < 0) {
                System.out.println("Invalid input. Please enter again.");
                continue;
            }
            salaries[i] = sal;
            serviceYears[i] = yrs;
        }
        for (int i = 0; i < 10; i++) {
            double bonusPercent = (serviceYears[i] > 5) ? 0.05 : 0.02;
            bonuses[i] = salaries[i] * bonusPercent;
            newSalaries[i] = salaries[i] + bonuses[i];
            totalOldSalary += salaries[i];
            totalBonus += bonuses[i];
            totalNewSalary += newSalaries[i];
        }
        System.out.println("\n--- Summary ---");
        System.out.printf("Total Old Salary: %.2f\n", totalOldSalary);
        System.out.printf("Total Bonus Paid: %.2f\n", totalBonus);
        System.out.printf("Total New Salary: %.2f\n", totalNewSalary);
    }
}