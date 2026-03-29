import java.util.Scanner;
public class UniqueCharacters {
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
            return count;
        }
    }
    public static char[] getUniqueChars(String str) {
        int n = findLength(str);
        char[] result = new char[n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (str.charAt(j) == ch) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                result[index++] = ch;
            }
        }
        char[] finalResult = new char[index];
        for (int i = 0; i < index; i++) {
            finalResult[i] = result[i];
        }
        return finalResult;
    }
    public static void display(char[] arr) {
        System.out.println("Unique Characters:");
        for (char c : arr) {
            System.out.print(c + " ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        char[] unique = getUniqueChars(str);
        display(unique);
        sc.close();
    }
}