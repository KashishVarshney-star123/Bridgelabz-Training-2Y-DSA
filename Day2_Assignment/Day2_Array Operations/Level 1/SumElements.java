import java.util.Scanner;

public class SumElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] nums = new double[10];
        double total = 0.0;
        int index = 0;
        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            double entry = sc.nextDouble();
            if (entry <= 0) break;
            if (index == 10) {
                System.out.println("Array is full.");
                break;
            }
            nums[index] = entry;
            index++;
        }
        for (int i = 0; i < index; i++) {
            total += nums[i];
            System.out.print(nums[i] + " ");
        }
        System.out.println("\nTotal value: " + total);
    }
}