import java.util.Scanner;

public class DDAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a very large number: ");
        String input = sc.next();
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;
        for (int i = 0; i < input.length(); i++) {
            if (index == maxDigit) {
                maxDigit += 10;
                int[] temp = new int[maxDigit];
                System.arraycopy(digits, 0, temp, 0, digits.length);
                digits = temp;
            }
            digits[index++] = Character.getNumericValue(input.charAt(i));
        }
        int largest = -1, secondLargest = -1;
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }
        System.out.println("Largest: " + largest + ", Second Largest: " + secondLargest);
    }
}