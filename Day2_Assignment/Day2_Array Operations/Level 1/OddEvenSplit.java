import java.util.Scanner;

public class OddEvenSplit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int number = sc.nextInt();
        if (number <= 0) {
            System.out.println("Error: Not a natural number.");
            return;
        }
        int size = number / 2 + 1;
        int[] odd = new int[size];
        int[] even = new int[size];
        int oIdx = 0, eIdx = 0;
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                even[eIdx++] = i;
            } else {
                odd[oIdx++] = i;
            }
        }
        System.out.print("Even numbers: ");
        for (int i = 0; i < eIdx; i++) System.out.print(even[i] + " ");
        System.out.print("\nOdd numbers: ");
        for (int i = 0; i < oIdx; i++) System.out.print(odd[i] + " ");
    }
}