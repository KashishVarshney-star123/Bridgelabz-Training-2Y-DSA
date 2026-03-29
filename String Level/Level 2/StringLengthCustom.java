import java.util.Scanner;
public class StringLengthCustom {
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int customLength = findLength(str);
        int builtinLength = str.length();
        System.out.println("Custom Length: " + customLength);
        System.out.println("Built-in Length: " + builtinLength);
    }
}