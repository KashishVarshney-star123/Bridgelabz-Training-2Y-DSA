import java.util.Scanner;
public class PalindromeCheck {
    public static boolean isPalindromeIterative(String str) {
        int start = 0, end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static boolean isPalindromeRecursive(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return isPalindromeRecursive(str, start + 1, end - 1);
    }
    public static char[] reverseArray(String str) {
        char[] arr = str.toCharArray();
        char[] rev = new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
            rev[i] = arr[arr.length - 1 - i];
        }
        return rev;
    }
    public static boolean isPalindromeArray(String str) {
        char[] original = str.toCharArray();
        char[] reversed = reverseArray(str);
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        System.out.println("Iterative: " + isPalindromeIterative(str));
        System.out.println("Recursive: " +
                isPalindromeRecursive(str, 0, str.length() - 1));
        System.out.println("Using Array: " + isPalindromeArray(str));
        sc.close();
    }
}