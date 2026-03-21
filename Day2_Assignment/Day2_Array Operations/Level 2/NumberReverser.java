import java.util.Scanner;

public class NumberReverser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        long number = sc.nextLong();
        String s = Long.toString(Math.abs(number));
        int count = s.length();
        int[] digits = new int[count];
        for (int i = 0; i < count; i++) {
            digits[i] = (int)(number % 10);
            number /= 10;
        }
        System.out.print("Reversed digits: ");
        for (int i = count - 1; i >= 0; i--) {
            System.out.print(digits[i]);
        }
    }
}