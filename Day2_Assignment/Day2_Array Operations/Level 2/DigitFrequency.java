import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String input = sc.next(); 
        int n = input.length();
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = Character.getNumericValue(input.charAt(i));
        }
        int[] frequency = new int[10];
        for (int i = 0; i < n; i++) {
            int currentDigit = digits[i];
            frequency[currentDigit]++;
        }
        System.out.println("\nDigit Frequency:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + " occurs " + frequency[i] + " times");
            }
        }
    }
}