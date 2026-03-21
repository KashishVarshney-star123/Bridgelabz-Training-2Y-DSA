import java.util.Scanner;
public class UniqueChars {
    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            return count;
        }
    }
    public static char[] findUnique(String text) {
        int len = getLength(text);
        char[] tempArray = new char[len];
        int uniqueCount = 0;
        for (int i = 0; i < len; i++) {
            char current = text.charAt(i);
            boolean isDuplicate = false;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == current) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                tempArray[uniqueCount++] = current;
            }
        }
        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = tempArray[i];
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        char[] unique = findUnique(input);
        System.out.print("Unique Characters: ");
        for (char c : unique) {
            System.out.print(c + " ");
        }
    }
}