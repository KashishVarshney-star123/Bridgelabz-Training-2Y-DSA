import java.util.Scanner;
public class ArraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] arr = new double[10];
        double sum = 0.0;
        int index = 0;
        while (true) {
            System.out.print("Enter number: ");
            double num = sc.nextDouble();
            if (num <= 0) {
                break;
            }
            arr[index] = num;
            index++;
            if (index == 10) {
                break;
            }
        }
        System.out.println("Entered numbers:");
        for (int i = 0; i < index; i++) {
            System.out.print(arr[i] + " ");
            sum += arr[i];
        }
        System.out.println("\nTotal Sum = " + sum);
        sc.close();
    }
}